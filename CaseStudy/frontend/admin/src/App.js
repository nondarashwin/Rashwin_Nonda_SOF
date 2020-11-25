import logo from './logo.svg';
import './App.css';
import Product from "./Product";
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
} from "react-router-dom";
import React, {Component} from "react";
import Store from "./Store";
import axios from "axios";
import AddProduct from "./AddProduct";
import AddStore from "./AddStore";
class App extends Component {
    state = {
        addProduct: true,
        addStore: false,
        Products: [], product: {id: "", name: "", type: "", info: "", cost: "", continuity: true}
    }
    componentDidMount() {
        axios.get("http://localhost:9090/api/products").then(res=>{let product=res.data
        let st=this.state
            st.Products=product
            this.setState(st)
        })
    }

    edit = (event,id) => {

        event.preventDefault()
        let st = this.state
        for (let product of st.Products) {
            if (product.id == id) {
                st.product = product
            }
        }
        this.setState(st)
        console.log("i have changed")
    }
    addProduct() {

        //let addProduct=!this.state.addProduct
        let st = this.state
        st.addProduct = !st.addProduct
        //console.log(addProduct)
        this.setState(st)


    }



    render() {
        return (

            <div className="App">

                <Router>
                    <div>
                        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
                            <ul className="navbar-nav mr-auto">
                                <li className="nav-item active">
                                    <Link className="nav-link" to="/">Home</Link>
                                </li>
                                <li className="nav-item active">
                                    <Link className="nav-link" to="/Product">Product</Link>
                                </li>
                                <li className="nav-item active">
                                    <Link className="nav-link" to="/Stores">Stores</Link>
                                </li>
                                <li className="nav-item dropdown">
                                    <a className="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                                       data-toggle="dropdown"
                                       aria-haspopup="true" aria-expanded="false">
                                        Add
                                    </a>
                                    <div className="dropdown-menu" aria-labelledby="navbarDropdown">
                                        <Link className="dropdown-item" to="/add/store">Store</Link>
                                        <div className="dropdown-divider"></div>
                                        <Link className="dropdown-item" to="/add/product">Product</Link>


                                    </div>
                                </li>
                            </ul>

                        </nav>
                        <br></br>

                        {/* A <Switch> looks through its children <Route>s and
            renders the first one that matches the current URL. */}
                        <Switch>
                            <Route path="/Product">

                                <div className="row">
                                    <Product Products={this.state.Products} edit={this.edit} app={this}/></div>
                            </Route>
                            <Route path="/Stores">
                                <div className="row">
                                    <Store/>
                                </div>
                            </Route>
                            <Route path="/add/store">

                                <AddStore/>
                            </Route>
                            <Route path="/edit/product/:id" component={AddProduct}>

                            </Route>
                            <Route path="/edit/store/:id" component={AddStore}>

                            </Route>
                            <Route path="/add/product">

                                <AddProduct/>
                            </Route>
                            <Route path="/">
                                <Home/>
                            </Route>

                        </Switch>
                    </div>

                </Router>


            </div>
        );
    }
}

function Home() {
    return <h2>Home</h2>
}


export default App;

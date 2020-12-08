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
import Login from "./Login";
import LoginVerifier from "./LoginVerifier";
import Navbar from "./Navbar";
import Stock from "./Stock";
import AddStock from "./AddStock";
import Bill from "./Bill";
import Home from "./Home";
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

                        {/* A <Switch> looks through its children <Route>s and
            renders the first one that matches the current URL. */}
                        <Switch>
                            <Route path="/Product">
                                <LoginVerifier check="both"/>
                                <Navbar/>
                                <div className="row">
                                    <Product Products={this.state.Products} edit={this.edit} app={this}/></div>
                            </Route>
                            <Route path="/Stores">
                                <LoginVerifier check="admin"/>
                                <Navbar/>
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
                            <Route path="/add/Stock">
                                <AddStock/>
                            </Route>
                            <Route path="/Bill">
                                <LoginVerifier check="store"/>
                                <Navbar/>
                                <Bill/>
                            </Route>
                            <Route path="/home">
                                <LoginVerifier check="both"/>
                                <Navbar/>
                                <Home/>
                            </Route>
                            <Route path="/Stock">
                                <LoginVerifier check={"store"}/>
                                <Navbar/>
                                <Stock/>
                            </Route>
                            <Route path="/">
                                <Login/>
                            </Route>


                        </Switch>
                    </div>

                </Router>


            </div>
        );
    }
}




export default App;

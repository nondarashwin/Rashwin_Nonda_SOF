import {Link} from "react-router-dom";
import React from "react";

const {Component} = require("react");

class Navbar extends Component{
    logout(){
        let check=JSON.parse(localStorage.getItem("users"))
        if(check!=null||check.status==true){
            check.status=false
        }
        localStorage.setItem("users",JSON.stringify(check))
        window.location.href="/"
    }
    render() {
        let check=localStorage.getItem("users")
        if(check!=null){
            check=JSON.parse(check)
        if(check.userId==0){
        return(
<div>
            <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
                <ul className="navbar-nav mr-auto">
                    <li className="nav-item active">
                        <Link className="nav-link" to="/home">
                            <img width="50" src="/img/bitmap.png"/>
                            Home</Link>
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
                            New
                        </a>
                        <div className="dropdown-menu" aria-labelledby="navbarDropdown">
                            <Link className="dropdown-item" to="/add/store">Store</Link>
                            <div className="dropdown-divider"></div>
                            <Link className="dropdown-item" to="/add/product">Product</Link>

                        </div>
                    </li>

                </ul>

                    <a className="btn-primary" onClick={this.logout.bind(this)}>Logout</a>

            </nav>
        <br></br>
</div>
        )}else{
           return( <div>
                <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
                    <ul className="navbar-nav mr-auto">
                        <li className="nav-item active">
                            <Link className="nav-link" to="/home">
                                <img width="50" src="/img/bitmap.png"/>
                                Home</Link>
                        </li>
                        <li className="nav-item active">
                            <Link className="nav-link" to="/Product">Product</Link>
                        </li>

                        <li className="nav-item">
                            <Link className="nav-link" to="/Bill">Bill</Link>
                        </li>
                        <li className="nav-item dropdown">
                            <a className="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                               data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="false">
                                New
                            </a>
                            <div className="dropdown-menu" aria-labelledby="navbarDropdown">

                                <Link className="dropdown-item" to="/add/Stock">Stock</Link>


                            </div>
                        </li>

                    </ul>
                    <a className="btn-primary" onClick={this.logout.bind(this)}>Logout</a>
                </nav>



                <br></br>
            </div>)
        }
    }
    }
}
export default Navbar;
import axios from "axios";
import LoginVerifier from "./LoginVerifier";
import Navbar from "./Navbar";
import React from "react";

const {Component} = require("react");

class AddStock extends Component {
    state = {stock: {storeId: "", productId: "", stock: ""},message:""}

    handleEvent(event) {
        event.preventDefault()
        let st = this.state
        st.stock[event.target.name] = event.target.value
        console.log(event.target.name)
        console.log(event.target.value)
        this.setState(st)
    }
    componentDidMount() {
        if(localStorage.getItem("users")!=null){
        let check=JSON.parse(localStorage.getItem("users"))
        let st=this.state
        st.stock.storeId=check.userId}
    }

    handleSubmit(event) {
        event.preventDefault()

        axios.post("http://localhost:9090/api/stock", this.state.stock)
            .then(res => {
                console.log(res);
                console.log(res.data);
                let st=this.state;
                st.message="Stock added";
                this.setState(st)
            }).catch(err=>{
            let st=this.state
            st.message=err.response.data.message
            this.setState(st)
        })


    }
    render() {
        console.log("yes")
        return(
            <div><LoginVerifier/><Navbar/><div className="row">
                <div className="col-3"></div>
                <div className="col-3">
                    <div className="jumbotron" style={{backgroundColor:"white",padding:"10px",align:"center",border: "3px solid black",margin: 0,
                        position: "absolute",top:"50%",left: "50%"}}>
                        <div align="center"><img width="100" src="/img/bitmap.png"/></div>
                        <h5> New Stock</h5>
                        <form onSubmit={this.handleSubmit.bind(this)}>

                            <div className="form-group">
                                <label>Product Id</label><input type="text" name="productId" value={this.state.stock.productId} id="productId"
                                                        onChange={this.handleEvent.bind(this)}/>
                            </div>
                            <div className="form-group">
                                <label>quantity</label><input type="text" name="stock" value={this.state.stock.stock}
                                                          id="name" onChange={this.handleEvent.bind(this)}/>
                            </div>
                            <div className="form-group">
                                <input type="submit" className="btn btn-primary" value="Submit"/></div>
                            <div className="text-danger">{this.state.message}</div>
                        </form></div></div></div></div>
        )
    }
}
export default AddStock;
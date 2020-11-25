import React, {Component} from "react";
import Bootstrap from 'bootstrap/dist/css/bootstrap.css'
import axios from "axios";
import * as queryString from "@babel/core";

class AddProduct extends Component {
    state = {
        product: {id: "", name: "", type: "", info: "", cost: "", continuity: true},
        match: this.props.match
    }

    handleEvent(event) {
        event.preventDefault()
        let st = this.state
        if (event.target.name != "id") {

            st.product[event.target.name] = event.target.value
        }
        /*if(event.target.name=="id"){
            st.product.id=event.target.value
        }*/


        this.setState(st)

    }

    handleSubmit(event) {
        event.preventDefault()

        axios.post("http://localhost:9090/api/product", this.state.product)
            .then(res => {
                console.log(res);
                console.log(res.data);
            })
        window.location.href="/product"

    }

    componentDidMount() {
        if (this.state.match != null) {
            console.log("http://localhost:9090/api/product/id/" + this.state.match.params.id)
            axios.get("http://localhost:9090/api/product/id/" + this.state.match.params.id).then(res => {
                let product = res.data
                let st = this.state
                st.product = product
                st.product.continuity=true
                this.setState(st)
            })
        }

    }

    render() {
        console.log("yes")
        return (
            <div className="row">
                <div className="col-3"></div>
                <div className="col">
            <div className="jumbotron" style={{backgroundColor:"white",padding:"10px",align:"center",border: "3px solid black",margin: 0,width:"400px",textAlign:"left",
                position: "absolute"}}>
            <form onSubmit={this.handleSubmit.bind(this)}>
                <div className="form-group">
                    <label htmlFor="id">id</label><input className="form-control"type="text" name="id" value={this.state.product.id} id="id"
                                            onChange={this.handleEvent.bind(this)} disabled/>
                </div>
                <div className="form-group">
                    <label htmlFor="name">name</label><input className="form-control"type="text" name="name" value={this.state.product.name}
                                              id="name" onChange={this.handleEvent.bind(this)}/>
                </div>
                <div className="form-group">
                    <label htmlFor="cost">cost</label><input className="form-control"type="text" name="cost" value={this.state.product.cost}
                                              id="cost" onChange={this.handleEvent.bind(this)}/></div>
                <div className="form-group">
                    <label htmlFor="type">category</label><input className="form-control"type="text" name="type"
                                                  value={this.state.product.type} id="type"
                                                  onChange={this.handleEvent.bind(this)}/></div>
                <div className="form-group">
                    <label htmlFor="info" style={{alignSelf:"left"}}>info</label><input type="text" className="form-control" name="info" value={this.state.product.info}
                                              id="info" onChange={this.handleEvent.bind(this)}/></div>
                <div className="form-group">
                    <input type="submit" className="btn btn-primary" value="Submit"/></div>
            </form></div></div></div>
        )
    }
}

export default AddProduct;
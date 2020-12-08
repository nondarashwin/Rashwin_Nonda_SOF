import React from "react";
import axios from "axios";
import Loading from "./Loading";

const {Component} = require("react");

class BilledProduct extends Component {
    state = {billedProducts: [],totalCost:0,costFlag:true,loading:false}

    componentDidMount() {
        let state=this.state;
        console.log(this.state.loading)

        state.loading=true
        this.setState(state,()=>{
        if (localStorage.getItem("billedProducts") != null ) {
            let billedProducts = JSON.parse(localStorage.getItem("billedProducts"));
            let totalCost=0;
            let billedProducts1=[];
            let costFlag=false
            for (let i of billedProducts) {
                axios.get("http://localhost:9090/api/product/id/" + i.productId).then(res => {
                    billedProducts1.push({
                        productId: i.productId,
                        quantity: i.quantity,
                        name: res.data.name,
                        cost: res.data.cost
                    })
                    totalCost += res.data.cost * i.quantity;
                    costFlag = true
                    console.log(totalCost)
                })
            }
            this.setState({billedProducts:billedProducts1,totalCost:totalCost,costFlag:costFlag,loading:false})
        }
        else{
            let state1=this.state;
            state.loading=false
            this.setState(state)
        }})
    }
    billedProductDisplay(){
       return( <div>{this.state.billedProducts.map((stock) => {
            return (<div className="card">
                <div className="card-body">
                    <div className="container-sm">
                        <b>Product Id:</b>{stock.productId}
                        <b>Product Name:</b>{stock.name}
                        <b>Quantity:</b>{stock.quantity}
                        <b>Product cost:</b>{stock.cost}
                        <b>cost:</b>{stock.cost*stock.quantity}
                    </div>
                </div>
            </div>)
       })
       }</div>)
    }

    render() {
        return <div>{this.state.loading?<Loading/>:this.billedProductDisplay()}
        TotalAmount{this.state.costFlag?this.state.totalCost:" "}</div>
    }
}

export default BilledProduct;
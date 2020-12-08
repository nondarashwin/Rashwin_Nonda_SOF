import axios from "axios";
import {Link} from "react-router-dom";
import React from "react";
import {Spinner} from "react-bootstrap";
import Loading from "./Loading";

const {Component} = require("react");

class Stock extends Component {
    state = {
        stocks: [], loading: false
    }

    stockPrint() {
        console.log("i have called")
        console.log(this.state.stocks)
        return <div className="row">{this.state.stocks.map((stock) => {
            console.log(stock)
            return (

                <div className="col">
                    <div className="card">
                        <div className="card-body">
                            <div className="container-sm">
                                <b>Product Id:</b>{stock.productId}<br></br>
                                <b>Product Name:</b>{stock.productName}<br></br>
                                <b>Quantity:</b>{stock.stock}
                            </div>
                        </div>
                    </div>
                </div>
            )
        })}</div>
    }

    componentDidMount() {
        let state = this.state
        state.loading = true
        this.setState(state, () => {
            let check = localStorage.getItem("users")
            check = JSON.parse(check)
            console.log(check.userId)
            axios.get("http://localhost:9090/api/store/stock/id/" + check.userId).then(res => {
                let stocks = res.data
                axios.get("http://localhost:9090/api/products").then(res => {
                    const products=res.data
                    let stocks1=[]
                    for(let stock of stocks){
                        for(let product of products){
                            if(stock.productId==product.id){
                                stock.productName=product.name
                                stocks1.push(stock)
                            }
                        }
                    }
                    let st = this.state
                    st.stocks = stocks1
                    st.loading = false
                    console.log(res.data)

                    this.setState(st)

                })

            })
        })
    }

    render() {
        return this.state.loading ? <Loading/> : this.stockPrint()
    }
}

export default Stock;
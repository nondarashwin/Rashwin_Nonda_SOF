import React from "react";
import axios from "axios";
import BilledProduct from "./BilledProduct";
import {Spinner} from "react-bootstrap";
import Loading from "./Loading";

const {Component} = require("react");


class Bill extends Component {
    state = {billedProduct: [], stock: {productId: "", quantity: "", emailId: ""}, loading: false}

    handleEvent(event) {
        event.preventDefault()
        let st = this.state
        st.stock[event.target.name] = event.target.value
        console.log(event.target.name)
        console.log(event.target.value)
        this.setState(st)
    }

    handleBill(event) {
        let st = this.state
        st.loading = true
        this.setState(st, () => {
            event.preventDefault()
            let check = JSON.parse(localStorage.getItem("users"))
            if (localStorage.getItem("billedProducts") != null) {
                let billedProducts = JSON.parse(localStorage.getItem("billedProducts"))
                let bill = {
                    billedProducts: billedProducts,
                    emailId: this.state.stock.emailId,
                    storeId: check.userId,
                }
                console.log(bill)
                axios.post("http://localhost:9090/api/bill", bill).then(
                    res => {
                        console.log(res.data);
                        localStorage.removeItem("billedProducts")
                        alert("bill has been mailed to " + bill.emailId)
                        let st1 = this.state
                        st1.loading = false
                        this.setState(st1)
                    }
                )
            }
        })
    }

    handleSubmit(event) {

        event.preventDefault()
        let stocks;
        console.log("im handle submit")
        let check = localStorage.getItem("users")

        check = JSON.parse(check)
        console.log(check.userId)
        axios.get("http://localhost:9090/api/store/stock/id/" + check.userId).then(res => {

            console.log("im first request")
            console.log(res.data)
            let stocks = res.data;
            let flag = true;

            let quantity = 0;
            for (let stock of stocks) {
                if (this.state.stock.productId == stock.productId) {
                    flag = false;
                    if (this.state.stock.quantity <= stock.stock) {
                        if (localStorage.getItem("billedProducts") != null) {
                            let billedProducts1 = []
                            let flag1 = true;
                            let billedProduct = JSON.parse(localStorage.getItem("billedProducts"))
                            for (let billed of billedProduct) {
                                if (billed.productId == this.state.stock.productId) {
                                    if (Number(this.state.stock.quantity) + Number(billed.quantity) > stock.stock) {
                                        alert("Stock is less then required")
                                    } else {
                                        if (Number(this.state.stock.quantity) + Number(billed.quantity) < 0) {
                                            alert("quantity Cant be negative")
                                        } else {
                                            if (Number(this.state.stock.quantity) + Number(billed.quantity) !== 0) {

                                                billedProducts1.push({
                                                    productId: this.state.stock.productId,
                                                    quantity: Number(this.state.stock.quantity) + Number(billed.quantity)
                                                })
                                            }
                                        }
                                    }
                                    flag1 = false;
                                    break;

                                } else {
                                    billedProducts1.push(billed)
                                }


                            }
                            if (flag1) {
                                billedProducts1.push({
                                    productId: this.state.stock.productId,
                                    quantity: this.state.stock.quantity
                                })
                            }
                            localStorage.setItem("billedProducts", JSON.stringify(billedProducts1));
                        } else {
                            let p = [{productId: this.state.stock.productId, quantity: this.state.stock.quantity}]
                            localStorage.setItem("billedProducts", JSON.stringify(p));
                        }
                        window.location.reload(false)
                        break;
                    } else {
                        alert("Stock is less then required")
                    }

                }
            }
            if (flag) {
                alert("Product not found")
            }
        })

    }

    resetBill() {
        if (localStorage.getItem("billedProducts") != null) {
            localStorage.removeItem("billedProducts")
            let state = this.state
            state.billedProduct = []
            this.setState(state)
        }
    }

    billForm() {
        return (
            <div>
                <form onSubmit={this.handleSubmit.bind(this)}>

                    <div className="form-group">
                        <label>Product Id</label><input type="text" name="productId" value={this.state.stock.productId}
                                                        id="productId"
                                                        onChange={this.handleEvent.bind(this)}/>

                        <label>quantity</label><input type="text" name="quantity" value={this.state.stock.quantity}
                                                      id="name" onChange={this.handleEvent.bind(this)}/>


                        <button type="submit" className="btn btn-primary">
                            <svg width="1em" height="1em" viewBox="0 0 16 16" className="bi bi-plus" fill="currentColor"
                                 xmlns="http://www.w3.org/2000/svg">
                                <path fill-rule="evenodd"
                                      d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
                            </svg>
                        </button>
                        <button className="btn btn-primary" onClick={this.resetBill.bind(this)}>
                            <svg width="1em" height="1em" viewBox="0 0 16 16" className="bi bi-bootstrap-reboot"
                                 fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                <path fill-rule="evenodd"
                                      d="M1.161 8a6.84 6.84 0 1 0 6.842-6.84.58.58 0 0 1 0-1.16 8 8 0 1 1-6.556 3.412l-.663-.577a.58.58 0 0 1 .227-.997l2.52-.69a.58.58 0 0 1 .728.633l-.332 2.592a.58.58 0 0 1-.956.364l-.643-.56A6.812 6.812 0 0 0 1.16 8zm5.48-.079V5.277h1.57c.881 0 1.416.499 1.416 1.32 0 .84-.504 1.324-1.386 1.324h-1.6zm0 3.75V8.843h1.57l1.498 2.828h1.314L9.377 8.665c.897-.3 1.427-1.106 1.427-2.1 0-1.37-.943-2.246-2.456-2.246H5.5v7.352h1.141z"/>
                            </svg>
                        </button>

                    </div>

                    <div className="text-danger">{this.state.message}</div>
                </form>

                <BilledProduct/>
                <form onSubmit={this.handleBill.bind(this)}>
                    <div className="form-group">
                        <label>email</label><input type="text" name="emailId" value={this.state.stock.emailId}
                                                   id="name" onChange={this.handleEvent.bind(this)}/>
                    </div>
                    <div className="form-group">

                        <button className="btn btn-primary">
                            <svg width="1em" height="1em" viewBox="0 0 16 16" className="bi bi-receipt"
                                 fill="currentColor"
                                 xmlns="http://www.w3.org/2000/svg">
                                <path fill-rule="evenodd"
                                      d="M1.92.506a.5.5 0 0 1 .434.14L3 1.293l.646-.647a.5.5 0 0 1 .708 0L5 1.293l.646-.647a.5.5 0 0 1 .708 0L7 1.293l.646-.647a.5.5 0 0 1 .708 0L9 1.293l.646-.647a.5.5 0 0 1 .708 0l.646.647.646-.647a.5.5 0 0 1 .708 0l.646.647.646-.647a.5.5 0 0 1 .801.13l.5 1A.5.5 0 0 1 15 2v12a.5.5 0 0 1-.053.224l-.5 1a.5.5 0 0 1-.8.13L13 14.707l-.646.647a.5.5 0 0 1-.708 0L11 14.707l-.646.647a.5.5 0 0 1-.708 0L9 14.707l-.646.647a.5.5 0 0 1-.708 0L7 14.707l-.646.647a.5.5 0 0 1-.708 0L5 14.707l-.646.647a.5.5 0 0 1-.708 0L3 14.707l-.646.647a.5.5 0 0 1-.801-.13l-.5-1A.5.5 0 0 1 1 14V2a.5.5 0 0 1 .053-.224l.5-1a.5.5 0 0 1 .367-.27zm.217 1.338L2 2.118v11.764l.137.274.51-.51a.5.5 0 0 1 .707 0l.646.647.646-.646a.5.5 0 0 1 .708 0l.646.646.646-.646a.5.5 0 0 1 .708 0l.646.646.646-.646a.5.5 0 0 1 .708 0l.646.646.646-.646a.5.5 0 0 1 .708 0l.646.646.646-.646a.5.5 0 0 1 .708 0l.509.509.137-.274V2.118l-.137-.274-.51.51a.5.5 0 0 1-.707 0L12 1.707l-.646.647a.5.5 0 0 1-.708 0L10 1.707l-.646.647a.5.5 0 0 1-.708 0L8 1.707l-.646.647a.5.5 0 0 1-.708 0L6 1.707l-.646.647a.5.5 0 0 1-.708 0L4 1.707l-.646.647a.5.5 0 0 1-.708 0l-.509-.51z"/>
                                <path fill-rule="evenodd"
                                      d="M3 4.5a.5.5 0 0 1 .5-.5h6a.5.5 0 1 1 0 1h-6a.5.5 0 0 1-.5-.5zm0 2a.5.5 0 0 1 .5-.5h6a.5.5 0 1 1 0 1h-6a.5.5 0 0 1-.5-.5zm0 2a.5.5 0 0 1 .5-.5h6a.5.5 0 1 1 0 1h-6a.5.5 0 0 1-.5-.5zm0 2a.5.5 0 0 1 .5-.5h6a.5.5 0 0 1 0 1h-6a.5.5 0 0 1-.5-.5zm8-6a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 0 1h-1a.5.5 0 0 1-.5-.5zm0 2a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 0 1h-1a.5.5 0 0 1-.5-.5zm0 2a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 0 1h-1a.5.5 0 0 1-.5-.5zm0 2a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 0 1h-1a.5.5 0 0 1-.5-.5z"/>
                            </svg>
                            Bill
                        </button>
                    </div>
                </form>
            </div>
        )
    }

    render() {
        return this.state.loading ?
            <div style={{align: "center", margin: 0, position: "absolute", top: "50%", left: "50%"}}><Loading/>
            </div> : this.billForm()
    }
}

export default Bill;
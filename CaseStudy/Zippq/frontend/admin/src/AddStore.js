import React, {Component} from "react";
import axios from "axios";
import LoginVerifier from "./LoginVerifier";
import Navbar from "./Navbar";
import {Spinner} from "react-bootstrap";
import Loading from "./Loading";

class AddStore extends Component {
    state = {
        store: {id: "", name: "", address: "", continuity: true},
        match: this.props.match,
        mailId: "",
        loading: false
    }

    handleEvent(event) {
        event.preventDefault()
        let st = this.state

        if (event.target.name != "id") {
            if (event.target.name == "mailId") {
                st.mailId = event.target.value
                //console.log(st.stor)
            } else {
                st.store[event.target.name] = event.target.value
            }
        }

        /*if(event.target.name=="id"){
            st.product.id=event.target.value
        }*/


        this.setState(st)

    }

    handleSubmit(event) {
        event.preventDefault()
        let st = this.state;
        st.loading = true;
        this.setState(st, () => {
            axios.post("http://localhost:9090/api/store", this.state.store)
                .then(res => {
                    console.log(res);
                    console.log(res.data);
                    let store = res.data;
                    axios.post("http://localhost:9090/api/storepassword", {
                        storeId: store.id,
                        mailId: this.state.mailId,
                        password: "password"
                    }).then(res1 => {
                        console.log(res1.data)
                        window.location.href = "/Stores"
                    })
                })
        })

    }

    storeForm() {
        return (
            <div><LoginVerifier check="admin"/><Navbar/>
                <div className="row">
                    <div className="col-3"></div>
                    <div className="col-3">
                        <div className="jumbotron" style={{
                            backgroundColor: "white",
                            padding: "10px",
                            align: "center",
                            border: "3px solid black",
                            margin: 0,
                            position: "absolute",
                            top: "50%",
                            left: "50%"
                        }}>
                            <div align="center"><img width="100" src="/img/bitmap.png"/></div>
                            <h5> New Store</h5>
                            <form onSubmit={this.handleSubmit.bind(this)}>


                                <div className="form-group">
                                    <label>name</label><input type="text" name="name" value={this.state.store.name}
                                                              id="name" onChange={this.handleEvent.bind(this)}/>
                                </div>
                                <div className="form-group">
                                    <label>address</label><input type="text" name="address"
                                                                 value={this.state.store.address}
                                                                 id="address" onChange={this.handleEvent.bind(this)}/>
                                </div>
                                <div className="form-group">
                                    <label>Email</label><input type="email" name="mailId" value={this.state.mailId}
                                                               id="mailId" onChange={this.handleEvent.bind(this)}/>
                                </div>
                                <div className="form-group">
                                    <input type="submit" className="btn btn-primary" value="Submit"/></div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        )
    }

    componentDidMount() {
        if (this.state.match != null) {

            axios.get("http://localhost:9090/api/store/id/" + this.state.match.params.id).then(res => {
                let store = res.data
                let st = this.state
                st.store = store
                axios.get("http://localhost:9090/api/getstore/" + store.id).then(res1 => {
                    st.mailId = res1.data.mailId;
                    console.log(st.mailId);
                    this.setState(st)

                })

            })
        }
    }

    render() {
        console.log("yes")
        return this.state.loading ?
            <div style={{align: "center", margin: 0, position: "absolute", top: "50%", left: "50%"}}><Loading/>
            </div> : this.storeForm()
    }
}

export default AddStore;
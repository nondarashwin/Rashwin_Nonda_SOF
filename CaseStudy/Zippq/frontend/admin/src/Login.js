import React from "react";
import axios from "axios";

const {Component} = require("react");

class Login extends Component {
    state = {user: {storeId: "", password: ""}, message: ""}

    handleSubmit(event) {
        event.preventDefault()

        console.log(this.state.user)

        axios.post("http://localhost:9090/api/getstorepassword", this.state.user)
            .then(res => {
                if (this.state.user.storeId == 0) {
                    localStorage.setItem("users", JSON.stringify({userId: this.state.user.storeId, status: true}))
                    window.location.href = "/home"
                }
                axios.get("http://localhost:9090/api/store/id/" + this.state.user.storeId).then(res => {
                    if (res.data.continuity) {
                        localStorage.setItem("users", JSON.stringify({userId: this.state.user.storeId, status: true}))
                        window.location.href = "/home"
                    } else {
                        let st = this.state
                        st.message = "userId not found"
                        this.setState(st)
                    }
                }).catch(err => {

                    let st = this.state
                    st.message = err.response.data.message
                    this.setState(st)
                })
            }).catch(err => {
            let st = this.state
            st.message = err.response.data.message
            this.setState(st)
        })

    }

    handleEvent(event) {
        event.preventDefault()
        let st = this.state
        st.user[event.target.name] = event.target.value
        this.setState(st)
    }

    render() {
        return (<div>
                <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
                    <div align="center"><img width="100" src="/img/bitmap.png"/></div>
                    ZippQ
                </nav>
                <div className="jumbotron" style={{
                    backgroundColor: "white", padding: "10px", align: "center", border: "1px groove black", margin: 0,
                    position: "absolute", top: "20%", left: "40%"
                }}>
                    <div align="center"><img width="100" src="/img/bitmap.png"/></div>
                    <h5> Log In</h5>
                    <form onSubmit={this.handleSubmit.bind(this)}>
                        <div className="form-group">
                            <label htmlFor="userName">userid</label><input className="form-control" type="text"
                                                                           onChange={this.handleEvent.bind(this)}
                                                                           name="storeId" id="storeId"/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="password">password</label><input className="form-control" type="password"
                                                                             name="password"
                                                                             onChange={this.handleEvent.bind(this)}
                                                                             id="password"/>
                        </div>

                        <button type="submit" className="btn btn-primary">LogIn</button>
                        <div className="text-danger">{this.state.message}</div>
                    </form>
                </div>
            </div>
        )
    }
}

export default Login
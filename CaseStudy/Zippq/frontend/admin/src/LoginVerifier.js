import React from "react";

const {Component} = require("react");

class LoginVerifier extends Component{
    render() {
        let check=localStorage.getItem("users")
        if(check==null){
            window.location.href="/"
        }
        check=JSON.parse(check)
        if(check.status==false){
            window.location.href="/"
        }
        //console.log(this.props.check)
        //console.log(this.props.check=="admin" && check.userId!=0)
        //console.log(check.userId!=0)
        //console.log(this.props.check=="admin")
        if(this.props.check=="admin" && check.userId!=0){
            console.log("im not admin")
            alert("Restricted Area")
            window.location.href="/home"

        }else{
            //console.log(check.userId>0)
        if(this.props.check=="store" && !check.userId>0){
            //console.log("im not store")

            alert("Restricted Area")
            window.location.href="/home"

        }
        }

        return(<div/>)
    }
}
export default LoginVerifier;
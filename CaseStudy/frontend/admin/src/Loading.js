import React from "react";

const {Component} = require("react");

class Loading extends Component{
    render() {
        return(
            <div className="spinner-border text-primary" role="status">
                <span className="sr-only">Loading...</span>
            </div>
        )
    }
}
export default Loading;
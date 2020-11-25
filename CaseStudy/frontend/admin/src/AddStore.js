import React,{Component} from "react";
import Bootstrap from 'bootstrap/dist/css/bootstrap.css'
import axios from "axios";
class AddStore extends Component{
    state={
        store:{id:"",name:"",address:"",continuity:true},
        match:this.props.match
    }
    handleEvent(event) {
        event.preventDefault()
        let st = this.state
        if(event.target.name!="id"){
        st.store[event.target.name] = event.target.value}
        /*if(event.target.name=="id"){
            st.product.id=event.target.value
        }*/



        this.setState(st)

    }
    handleSubmit(event) {
        event.preventDefault()

        axios.post("http://localhost:9090/api/store", this.state.store)
            .then(res => {
                console.log(res);
                console.log(res.data);
            })
        window.location.href="/store"
    }
    componentDidMount() {
        if(this.state.match!=null){
            console.log("http://localhost:9090/api/product/id/"+this.state.match.params.id)
            axios.get("http://localhost:9090/api/store/id/"+this.state.match.params.id).then(res=>{let store=res.data
                let st=this.state
                st.store=store
                this.setState(st)
            })
        }
    }

    render() {
        console.log("yes")
        return(<div className="row">
            <div className="col-3"></div>
            <div className="col-3">
            <div className="jumbotron" style={{backgroundColor:"white",padding:"10px",align:"center",border: "3px solid black",margin: 0,
                position: "absolute",top:"50%",left: "50%"}}>
            <form onSubmit={this.handleSubmit.bind(this)}>

        <div className="form-group">
                <label>id</label><input type="text" name="id" value={this.state.store.id} id="id"
                                        onChange={this.handleEvent.bind(this)}disabled/>
        </div>
                <div className="form-group">
                <label>name</label><input type="text" name="name" value={this.state.store.name}
                                          id="name" onChange={this.handleEvent.bind(this)}/>
                </div>
                <div className="form-group">
                <label>address</label><input type="text" name="address" value={this.state.store.address}
                                          id="cost" onChange={this.handleEvent.bind(this)}/>
                </div>
                <div className="form-group">
                    <input type="submit" className="btn btn-primary" value="Submit"/></div>
            </form></div></div></div>
        )
    }
}
export default AddStore;
import React,{Component} from "react";
import Bootstrap from 'bootstrap/dist/css/bootstrap.css'
import axios from "axios";
import AddProduct from "./AddProduct";
import {Link} from "react-router-dom";
class Product extends Component{
    state={
        Products:[{id:1,name:"Laptop",type:"Electonics",info:"8GB RAM,Intel I3",cost:330000,continuity:true},
            {id:2,name:"Mobile",type:"Electonics",info:"8GB RAM,128GB Memory",cost:78000,continuity:false},{id:3,name:"trimmer",type:"Electonics",info:"8 hours back up",cost:7800,continuity:false}
        ]
    }
    componentDidMount() {
        axios.get("http://localhost:9090/api/products").then(res=>{let product=res.data
            let st=this.state
            st.Products=product
            this.setState(st)
        })
    }
    deleteProduct(productId){
        axios.delete('http://localhost:9090/api/product/id/' + productId).then(res => {
            console.log(res);
            console.log(res.data);
        })
        //this.componentDidMount()
        window.location.reload(false)
    }
    editProduct(productId){
        return <AddProduct product={this.state.Products[0]} />
    }
    render() {

        return this.state.Products.map((product)=> {
            var myStyle={ color: "black" };
            if(product.continuity==false){
                myStyle.color="red"
            }
            return(

                <div className="col-3" style={myStyle} key={product.id}>
                <div className="card" ><h5 className="card-title">{product.name}</h5><img src="img/product.jpeg"
                                                                                          className="card-img-top"
                                                                                          alt="Product Image Link is Broken"
                                                                                                  width="100" height="200"></img>
                    <div className="card-body">
                        <div className="container-sm">
                            <b>Id:</b>{product.id}<br></br><b>Name:</b>{product.name}<br></br><b>Category:</b>{product.type}<br></br><b>Cost:</b>{product.cost}<br></br>

                            <Link className="btn btn-primary" to={"/edit/product/"+product.id}><svg width="1em" height="1em" viewBox="0 0 16 16" className="bi bi-pencil"
                                                                        fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                <path fill-rule="evenodd"
                                      d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5L13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175l-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"></path>
                            </svg>Edit</Link>
                            <a href="#" className="btn btn-danger"
                                        onClick={this.deleteProduct.bind(this,product.id)}>
                            <svg width="1em" height="1em" viewBox="0 0 16 16" className="bi bi-trash"
                                 fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                <path
                                    d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"></path>
                                <path fill-rule="evenodd"
                                      d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"></path>
                            </svg>
                                Delete</a>
                            </div>
                    </div></div>
            </div>)})
    }
}
export default Product
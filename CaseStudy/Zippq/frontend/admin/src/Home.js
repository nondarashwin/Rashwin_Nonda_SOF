import React from "react";
import axios from "axios";
import Spinner from "react-bootstrap/Spinner";
import Stock from "./Stock";

const {Component} = require("react");
const Chart = require("chart.js")

class Home extends Component {
    state={loading:false}
    topSellingProduct(){
        //http://localhost:9090/api/topSellingProduct
        let data = [];
        let label = [];
        let value = []
        axios.get("http://localhost:9090/api/topSellingProduct").then(res => {
            console.log(res.data)
            data = res.data;
            for (let i of data) {
                label.push(i[0] + "(" + i[1] + ")");
                value.push(i[2]);
            }
            console.log(data)
            console.log(label)
            console.log(value)
            let ctx = document.getElementById('topSellingProduct')
            if(ctx!=null){
                ctx=ctx.getContext('2d');
            const myChart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: label,
                    datasets: [{
                        label: 'Total sale of Product',
                        data: value, backgroundColor: [
                            'rgba(255, 99, 132, 0.2)',
                            'rgba(54, 162, 235, 0.2)',
                            'rgba(255, 206, 86, 0.2)',
                            'rgba(75, 192, 192, 0.2)',
                            'rgba(153, 102, 255, 0.2)',
                            'rgba(255, 159, 64, 0.2)'
                        ],
                        borderColor: [
                            'rgba(255, 99, 132, 1)',
                            'rgba(54, 162, 235, 1)',
                            'rgba(255, 206, 86, 1)',
                            'rgba(75, 192, 192, 1)',
                            'rgba(153, 102, 255, 1)',
                            'rgba(255, 159, 64, 1)'
                        ],
                        borderWidth: 1
                    }]
                },
                options: {
                    scales: {
                        yAxes: [{
                            ticks: {
                                beginAtZero: true,

                            }, display: true,
                            scaleLabel: {
                                display: true,
                                labelString: 'Amount(Rs)'
                            }
                        }],xAxes:[{display: true,
                            scaleLabel: {
                                display: true,
                                labelString: 'Store Name(Store Id)'
                            }}]
                    }
                }
            });
        }})
    }
    topSellingProductByStore(){
        //http://localhost:9090/api/topSellingProduct
        let data = [];
        let label = [];
        let value = []
        let check=localStorage.getItem("users")
        if(check!=null){
            check=JSON.parse(check)
        }
        axios.get("http://localhost:9090/api/topSellingProduct/store/"+check.userId).then(res => {
            console.log(res.data)
            data = res.data;
            for (let i of data) {
                label.push(i[0] + "(" + i[1] + ")");
                value.push(i[2]);
            }
            console.log(data)
            console.log(label)
            console.log(value)
            let ctx = document.getElementById('topSellingProductByStore')
            if(ctx!=null){
                ctx=ctx.getContext('2d');
                const myChart = new Chart(ctx, {
                    type: 'bar',
                    data: {
                        labels: label,
                        datasets: [{
                            label: 'Total sale of Product',
                            data: value, backgroundColor: [
                                'rgba(255, 99, 132, 0.2)',
                                'rgba(54, 162, 235, 0.2)',
                                'rgba(255, 206, 86, 0.2)',
                                'rgba(75, 192, 192, 0.2)',
                                'rgba(153, 102, 255, 0.2)',
                                'rgba(255, 159, 64, 0.2)'
                            ],
                            borderColor: [
                                'rgba(255, 99, 132, 1)',
                                'rgba(54, 162, 235, 1)',
                                'rgba(255, 206, 86, 1)',
                                'rgba(75, 192, 192, 1)',
                                'rgba(153, 102, 255, 1)',
                                'rgba(255, 159, 64, 1)'
                            ],
                            borderWidth: 1
                        }]
                    },
                    options: {
                        scales: {
                            yAxes: [{
                                ticks: {
                                    beginAtZero: true,

                                }, display: true,
                                scaleLabel: {
                                    display: true,
                                    labelString: 'Amount(Rs)'
                                }
                            }],xAxes:[{display: true,
                                scaleLabel: {
                                    display: true,
                                    labelString: 'Store Name(Store Id)'
                                }}]
                        }
                    }
                });
            }})
    }
    totalSales() {
        //http://localhost:9090/api/salesStore
        let data = [];
        let label = [];
        let value = []
        axios.get("http://localhost:9090/api/salesStore").then(res => {
            console.log(res.data)
            data = res.data;
            for (let i of data) {
                label.push(i[0] + "(" + i[1] + ")");
                value.push(i[2]);
            }
            console.log(data)
            console.log(label)
            console.log(value)
            let ctx = document.getElementById('totalSales')
            if(ctx!=null){
                ctx=ctx.getContext('2d');
            const myChart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: label,
                    datasets: [{
                        label: 'Total sales of Store',
                        data: value, backgroundColor: [
                            'rgba(255, 99, 132, 0.2)',
                            'rgba(54, 162, 235, 0.2)',
                            'rgba(255, 206, 86, 0.2)',
                            'rgba(75, 192, 192, 0.2)',
                            'rgba(153, 102, 255, 0.2)',
                            'rgba(255, 159, 64, 0.2)'
                        ],
                        borderColor: [
                            'rgba(255, 99, 132, 1)',
                            'rgba(54, 162, 235, 1)',
                            'rgba(255, 206, 86, 1)',
                            'rgba(75, 192, 192, 1)',
                            'rgba(153, 102, 255, 1)',
                            'rgba(255, 159, 64, 1)'
                        ],
                        borderWidth: 1
                    }]
                },
                options: {
                    scales: {
                        yAxes: [{
                            ticks: {
                                beginAtZero: true,

                            }, display: true,
                            scaleLabel: {
                                display: true,
                                labelString: 'No of unit'
                            }
                        }],xAxes:[{display: true,
                            scaleLabel: {
                                display: true,
                                labelString: 'Product Name(Product Id)'
                            }}]
                    }
                }
            });
        }})


    }
    componentDidMount() {
        this.setState({loading:true},()=>{this.totalSales()
            this.topSellingProduct()
            this.topSellingProductByStore()
            this.setState({loading:false})
        })

    }

    render() {
        let check=localStorage.getItem("users")
        if(check!=null){
            check=JSON.parse(check);
            if(check.userId==0){
        return (<div>
                <h2>Total Sales Of Each Store</h2>
                <canvas id="totalSales" style={{position: "relative", height: "40vh", width: "80vw"}}></canvas>
                <h2>Total Sale Of Product</h2>

                <canvas id="topSellingProduct" style={{position: "relative", height: "40vh", width: "80vw"}}></canvas>
            </div>
        )}
            else{
               return( <div>
                   <h2>Total Sale Of Product</h2>
                    <canvas id="topSellingProductByStore" style={{position: "relative", height: "40vh", width: "80vw"}}></canvas>
                   <h2>Stock</h2>
                   <Stock/>
                </div>)
            }
        }
    }
}

export default Home
import React, {Component} from 'react';
import axios from 'axios'
import '../css/App.css'
import 'bootstrap/dist/css/bootstrap.min.css';

class Demo extends Component {
    constructor(props) {
        super(props);
        this.state = {
            id: '',
            name: '',
            list: []
        }
    }

    render() {
        return (
            <div className="container-fluid" style={{marginTop: '20px'}}>
                <div className="row">
                    <div className="col-xs-4 col-xs-offset-1">
                        <table className="table table-bordered">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Gender</th>
                                <th>Birthday</th>
                                <th>Email</th>
                                <th>Contact Number</th>
                                <th>Start Date</th>
                                <th>End Date</th>
                                <th>Address</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            {
                                this.state.list.map(item => {
                                    return (
                                        <tr key={item.id}>
                                            <td>{item.id}</td>
                                            <td>{item.name}</td>
                                            <td>{item.gender}</td>
                                            <td>{item.birthday}</td>
                                            <td>{item.email}</td>
                                            <td>{item.contactNumber}</td>
                                            <td>{item.startDate}</td>
                                            <td>{item.endDate}</td>
                                            <td>{item.department.zipCode}</td>
                                            <td>
                                                <button className="btn btn-primary" onClick={() => {
                                                    this.setState({id: item.id, name: item.name})
                                                }}>修改
                                                </button>
                                                <button className="btn btn-danger" style={{marginLeft: '5px'}}
                                                        onClick={() => {
                                                            this.deleteItem(item)
                                                        }}>删除
                                                </button>
                                            </td>
                                        </tr>
                                    )
                                })
                            }
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
        );
    }

    // componentDidMount() {
    //     this.query();
    // };

    //React周期函数，防止死循环,在组建被渲染前调用
    componentWillMount() {
        this.getData();
    };

    // query = () => {
    //     axios.get('/customers/list').then(({data}) => {
    //         this.setState({
    //             list: data
    //         });
    //     })
    // };

    getData() {
        //修改请求头
        let myHeaders = new Headers({
            'Access-Control-Allow-Origin': '*',
            'Content-Type': 'text/plain'
        });
        fetch('/customers/list', {
            method: 'GET',
            headers: myHeaders,
            mode: 'cors',
            //转或称字符串格式
        }).then(res => res.json()).then(
            data => {
                this.setState({
                    list: data
                });
                console.log(data);
            }
        )
    }

    deleteItem = (item) => {
        axios.delete(`/customers/list/${item.id}`).then(({data}) => {
            console.log(data);
            this.query();
        })
    };

    handleFormSubmit = (e) => {
        e.preventDefault();
        if (this.state.name !== '') {
            axios.post('/customers/list', {
                id: !this.state.id ? '' : this.state.id,
                name: this.state.name
            }).then(({data}) => {
                this.setState({
                    id: '',
                    name: ''
                });
                this.query();
            })
        }
    }
}

export default Demo;

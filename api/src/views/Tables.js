import React, {Component} from "react";
import {Container, Row, Col, Card, CardHeader, CardBody} from "shards-react";

import PageTitle from "../components/common/PageTitle";

class Tables extends Component {
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
            <Container fluid className="main-content-container px-4">
                {/* Page Header */}
                <Row noGutters className="page-header py-4">
                    <PageTitle sm="4" title="Add New Post" subtitle="Blog Posts" className="text-sm-left"/>
                </Row>

                {/* Default Light Table */}
                <Row>
                    <Col>
                        <Card small className="mb-4">
                            <CardHeader className="border-bottom">
                                <h6 className="m-0">Active Users</h6>
                            </CardHeader>
                            <CardBody className="p-0 pb-3">
                                <table className="table mb-0">
                                    <thead className="bg-light">
                                    <tr>
                                        <th scope="col" className="border-0">
                                            #
                                        </th>
                                        <th scope="col" className="border-0">ID</th>
                                        <th scope="col" className="border-0">Name</th>
                                        <th scope="col" className="border-0">Gender</th>
                                        <th scope="col" className="border-0">Birthday</th>
                                        <th scope="col" className="border-0">Email</th>
                                        <th scope="col" className="border-0">Contact Number</th>
                                        <th scope="col" className="border-0">Start Date</th>
                                        <th scope="col" className="border-0">End Date</th>
                                        <th scope="col" className="border-0">Address</th>
                                        <th scope="col" className="border-0">操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    {
                                        this.state.list.map(item => {
                                            return (
                                                <tr key={item.id}>
                                                    <td></td>
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
                            </CardBody>
                        </Card>
                    </Col>
                </Row>

                {/* Default Dark Table */}
                <Row>
                    <Col>
                        <Card small className="mb-4 overflow-hidden">
                            <CardHeader className="bg-dark">
                                <h6 className="m-0 text-white">Active Users</h6>
                            </CardHeader>
                            <CardBody className="bg-dark p-0 pb-3">
                                <table className="table table-dark mb-0">
                                    <thead className="thead-dark">
                                    <tr>
                                        <th scope="col" className="border-0">
                                            #
                                        </th>
                                        <th scope="col" className="border-0">ID</th>
                                        <th scope="col" className="border-0">Name</th>
                                        <th scope="col" className="border-0">Gender</th>
                                        <th scope="col" className="border-0">Birthday</th>
                                        <th scope="col" className="border-0">Email</th>
                                        <th scope="col" className="border-0">Phone</th>
                                        <th scope="col" className="border-0">Start Date</th>
                                        <th scope="col" className="border-0">End Date</th>
                                        <th scope="col" className="border-0">Address</th>
                                        <th scope="col" className="border-0">操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    {
                                        this.state.list.map(item => {
                                            return (
                                                <tr key={item.id}>
                                                    <td></td>
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
                            </CardBody>
                        </Card>
                    </Col>
                </Row>
            </Container>
        )
    }

    componentWillMount() {
        this.getData();
    };

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

}

export default Tables;

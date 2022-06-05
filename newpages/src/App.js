import Header from "./components/Header";
import {Sider} from "./components/LeftContainer";
import MainContainer from "./components/MainContainer";
import React from "react";

class App extends React.Component {

    constructor() {
        super();
        this.state = {
            showContent: undefined
        }
    }

    setContent = (content) => {
        this.setState({
            showContent: content
        })
    }

    render() {
        return (
            <div className="App">
                <Header/>
                <Sider setContent={this.setContent}/>
                <MainContainer content={this.state.showContent}/>
            </div>
        );
    }
}

export default App;
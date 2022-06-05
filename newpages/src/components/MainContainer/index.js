import React, {Component} from 'react';
import ReactMarkdown from 'react-markdown'
import './index.css'
import 'github-markdown-css/github-markdown.css'
import {loadDefaultMarkdownFile} from '../utils/loadMdFile'
import remarkGfm from 'remark-gfm'

class MainContainer extends Component {

    constructor() {
        super();
        this.state = {content: null}
        loadDefaultMarkdownFile().then(res => {
            this.setState({
                content: res
            })
        })
    }

    render() {
        let {content} = this.props
        if(content === undefined || content.length.toString().trim().length === 0) {
            content = this.state.content
        }

        return (
            <div className='main-container'>
                {/*<Skeleton/>*/}
                <ReactMarkdown
                    className="markdown-body"
                    remarkPlugins={[remarkGfm]}
                >{content}
                </ReactMarkdown>
            </div>
        );
    }
}


export default MainContainer;
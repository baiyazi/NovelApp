import React, {Component} from 'react';
import {CaretDownOutlined} from '@ant-design/icons';
import {Menu, Dropdown} from 'antd';
import './index.css'
import UserProfile from "../UserProfile";


const menu = (
    <Menu>
        <Menu.Item key="1"><UserProfile/></Menu.Item>
        <Menu.Item key="2" disabled>没有了</Menu.Item>
    </Menu>
);

class Header extends Component {

    render() {
        let {title, author, authorLink, otherLinkName, otherLink} = this.props;
        title = title !== undefined ? title : '后台接口API文档';
        author = author !== undefined ? author : '梦否';
        authorLink = authorLink !== undefined ? authorLink : 'https://blog.csdn.net/qq_26460841/';
        otherLinkName = otherLinkName !== undefined ? otherLinkName : 'Github';
        otherLink = otherLink !== undefined ? otherLink : 'https://github.com/baiyazi';
        return (
            <div className='header'>
                <div className='header-logo'>{title}</div>
                <div className='header-author'>
                    作者：<a href={authorLink} target='_blank'>{author}</a>
                </div>
                <div className='header-right'>
                    <div></div>
                    <div><a href={otherLink} target='_blank'>{otherLinkName}</a></div>
                    <div>v1.1</div>
                    <div>
                        <Dropdown overlay={menu}>
                            <a className="ant-dropdown-link" href="#">
                                more <CaretDownOutlined />
                            </a>
                        </Dropdown>
                    </div>
                </div>
            </div>
        );
    }
}


export default Header;
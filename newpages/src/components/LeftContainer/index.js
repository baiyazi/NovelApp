import React, {Component} from 'react';
import {Menu, Input, notification } from 'antd';
import {ConsoleSqlOutlined, SmileOutlined } from '@ant-design/icons'
import 'antd/dist/antd.css'
import './index.css'
import {articles_total} from "../const/navData";
import {loadMarkdownFileByUrl} from "../utils/loadMdFile";

const {Search} = Input
const SubMenu = Menu.SubMenu;

const openNotification = () => {
    notification.open({
        message: 'Notification Title',
        description:
            '搜索功能没有实现。',
        icon: (
            <SmileOutlined
                style={{
                    color: '#108ee9',
                }}
            />
        ),
    });
};

class Sider extends Component {
    constructor() {
        super();
        this.state = {
            theme: 'light'
        }
    }

    onSearch = (value) => openNotification()

    handleClick = (e) => {
        let item = null
        if(e.key === 'summary') {
            item = articles_total.filter((item, index) => {
                return item.key === e.key
            })[0]
        }
        if(item !== null) {
            loadMarkdownFileByUrl(item.url).then(r => {
                this.props.setContent(r)
            });
        }
    }

    render() {
        return (
            <div className='left-container'>
                <Search
                    placeholder="关键字搜索"
                    allowClear
                    size='middle'
                    onSearch={this.onSearch}
                    enterButton
                    style={{
                        width: 240,
                        marginBottom: 8,
                        marginTop: 8
                    }}
                />
                <Menu theme={this.state.theme}
                      onClick={this.handleClick}
                      style={{width: 240, border: '1px solid #efefef'}}
                      defaultOpenKeys={['sub1']}
                      selectedKeys={[this.state.current]}
                      mode="inline">
                    <SubMenu key="sub1" title={<span><ConsoleSqlOutlined/><span>后端接口文档-粗略版</span></span>}>
                        <Menu.Item key={articles_total[0].key}>{articles_total[0].name}</Menu.Item>
                    </SubMenu>
                </Menu>
            </div>
        );
    }
}

export {
    Sider
};
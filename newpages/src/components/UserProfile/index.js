
import React, { useState } from 'react';
import { Drawer, Row, Col, Divider, Timeline} from 'antd';
import 'antd/dist/antd.css'

const DescriptionItem = ({ title, content }) => (
    <div className="site-description-item-profile-wrapper">
        <p className="site-description-item-profile-p-label">{title}: {content}</p>
    </div>
);

const UserProfile = (props) => {
    const [visible, setVisible] = useState(false);

    const showDrawer = () => {
        setVisible(true);
    };

    const onClose = () => {
        setVisible(false);
    };

    var {author, email} = props
    author = author !== undefined? author: '梦否';
    email = email !== undefined? email: '1270563429@qq.com';

    return (
        <>
            <span onClick={showDrawer}>关于作者</span>
            <Drawer width={640} title="关于作者" placement="right" onClose={onClose} visible={visible}>
                <p
                    className="site-description-item-profile-p"
                    style={{
                        marginBottom: 24,
                        fontWeight: "bolder",
                        fontSize: '1.3rem',
                        color: '#1890FF'
                    }}
                >基本信息
                </p>
                <Row>
                    <Col span={12}>
                        <DescriptionItem title="Full Name" content={author} />
                    </Col>
                    <Col span={12}>
                        <DescriptionItem title="Email" content={email} />
                    </Col>
                </Row>
                <Divider />
                <p
                    className="site-description-item-profile-p"
                    style={{
                        marginBottom: 24,
                        fontWeight: "bolder",
                        fontSize: '1.3rem',
                        color: '#1890FF'
                    }}
                >时间线
                </p>
                <Row>
                    <Timeline mode='left'>
                        <Timeline.Item label="2022-06-03">决定为之前写的《小说后台项目》添加接口说明文档</Timeline.Item>
                        <Timeline.Item label="2022-06-04">调研和实验了下Swagger、Smart-doc等，感觉不好用。决定使用React来写一个简易版本的。</Timeline.Item>
                        <Timeline.Item>简单回顾了一些关于React和ES6的语法，并考虑直接使用ant-design来搭积木</Timeline.Item>
                        <Timeline.Item label="2022-06-05">考虑添加markdown文件来显示编辑内容，引入react-markdown来显示简单md文件语法；但因为
                        不支持表格，引入了remark-gfm来渲染表格，关于其使用请查看地址：https://github.com/remarkjs/react-markdown</Timeline.Item>
                    </Timeline>
                </Row>
            </Drawer>
        </>
    );
};


export default UserProfile;
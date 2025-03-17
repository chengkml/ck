import React, { useState } from 'react';
import { Button, Input, Form, Message } from '@arco-design/web-react';
import "@arco-design/web-react/dist/css/arco.css";

const Login = () => {
  const [form] = Form.useForm();
  const [loading, setLoading] = useState(false);

  const onFinish = async (values) => {
    setLoading(true);
    try {
      // 模拟登录请求
      await new Promise((resolve) => setTimeout(resolve, 1000));
      Message.success('登录成功');
    } catch (error) {
      Message.error('登录失败，请重试');
    } finally {
      setLoading(false);
    }
  };

  return (
<div className="login-container" style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', height: '100vh', backgroundColor: '#f0f2f5', padding: '20px' }}>
<div className="login-form" style={{ padding: '20px', backgroundColor: '#fff', borderRadius: '8px', boxShadow: '0 4px 8px rgba(0, 0, 0, 0.1)', width: '300px' }}>
<h1 className="login-title" style={{ marginBottom: '20px', textAlign: 'center', fontSize: '24px', fontWeight: 'bold' }}>登录</h1>
      <Form form={form} layout="vertical" onFinish={onFinish}>
<Form.Item label="用户名" field="username" rules={[{ required: true, message: '请输入用户名' }]}>
          <Input placeholder="请输入用户名" />
        </Form.Item>
<Form.Item label="密码" field="password" rules={[{ required: true, message: '请输入密码' }]}>
          <Input.Password placeholder="请输入密码" />
        </Form.Item>
        <Form.Item>
<Button type="primary" htmlType="submit" loading={loading} className="login-button" style={{ width: '100%', marginTop: '20px' }}>
            登录
          </Button>
        </Form.Item>
</Form>
  </div>
    </div>
  );
};

export default Login;

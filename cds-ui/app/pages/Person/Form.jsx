import React, { Component } from 'react';
import { Form, Input, Button, InputNumber } from 'antd';
import { assign } from 'lodash';
import { Util } from '@gza/quantex-utils';
import { Select } from '@gza/quantex-design';
import style from './style.scss';

const FormItem = Form.Item;

/**
 * 表单组件
 */
class FormComponent extends Component {
  static defaultProps = {
    dataSource: {},
  };
  handleSubmit = e => {
    e.preventDefault();
    const { form, type, store, onClose, originData, dataSource, handleRloadTable } = this.props;
    form.validateFields(async err => {
      if (!err) {
        let formData = form.getFieldsValue();
        let params = assign({}, originData, Util.buildFormData(formData));
        if (type === 'add') {
          const res = await store.addPerInfo(params);
          if (res.code == 200) {
            handleRloadTable();
            onClose();
          }
        } else {
          const res = await store.updatePerInfo(params);
          if (res.code == 200) {
            handleRloadTable();
            onClose();
          }
        }
      }
    });
  };

  checkNumber = (rule, value, callback) => {
    if (/^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\d{8}$/.test(value)) {
      callback();
    } else {
      callback('请填写合法的电话号码');
    }
  };
  render() {
    const { form, type } = this.props;
    const { getFieldDecorator } = form;
    return (
      <Form className="form-content-wrapper" onSubmit={this.handleSubmit}>
        <div className="form-main-content">
          <div className="form-row-multi-items">
            <FormItem label="姓名">
              {getFieldDecorator('name', {
                rules: [{ required: true, message: '必填' }],
                validateTrigger: ['onBlur'],
              })(<Input size="small" disabled={type=='edit' ? true : false} />)}
            </FormItem>
            <FormItem label="年龄">
              {getFieldDecorator('age', {
                rules: [{ required: true, message: '必填' }],
                validateTrigger: ['onBlur'],
              })(<InputNumber size="small" min={1} width="100%" />)}
            </FormItem>
          </div>
          <div className="form-row-multi-items">
            <FormItem label="性别">
              {getFieldDecorator('gender', {
                rules: [{ required: true, message: '必填' }],
              })(
                <Select
                  dictData={[
                    { id: 1, name: '男' },
                    { id: 2, name: '女' },
                  ]}
                />
              )}
            </FormItem>
            <Form.Item label="电话">
              {getFieldDecorator('number', {
                rules: [
                  { required: true, message: '必填' },
                  {
                    validator: this.checkNumber,
                  },
                ],
                validateTrigger: ['onBlur'],
              })(<Input size="small" />)}
            </Form.Item>
          </div>
        </div>
        <div className="form-btn-wrapper">
          <Button size="small" type="primary" htmlType="submit">
            提交
          </Button>
        </div>
      </Form>
    );
  }
}

const RoleForm = Form.create({
  mapPropsToFields(props) {
    return Util.mapPropsToFields(props.dataSource, {
      enable: {
        dataType: 'boolean',
      },
    });
  },
})(FormComponent);
export default RoleForm;

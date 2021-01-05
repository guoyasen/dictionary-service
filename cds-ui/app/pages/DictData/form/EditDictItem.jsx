import React, { Component } from 'react';
import { assign } from 'lodash';
import { Form, Input, Button } from 'antd';
import { Util } from 'utils';

const FormItem = Form.Item;
/**
 * 编辑字典子项表单
 */
class EditDictItemFormComponent extends Component {
  /**
   * 提交表单
   * @param e
   */
  handleSubmit = (e) => {
    e.preventDefault();
    const { form, store, dataSource, parentData } = this.props;
    form.validateFields((err, values) => {
      if (!err) {
        let params = Util.buildFormData(values);
        params.id = dataSource.id; // 字典子项ID
        store.updateDictItem(params, parentData.id);
      }
    });
  };

  render() {
    const { getFieldDecorator } = this.props.form;
    const { dictKey } = this.props.parentData;
    return (
      <Form className="form-content-wrapper" onSubmit={this.handleSubmit}>
        <div className="form-main-content">
          <div className="form-row-multi-items">
            <FormItem label="字典key">
              <Input size="small" type="text" value={dictKey} disabled />
            </FormItem>
            <FormItem label="字典值">
              {
                getFieldDecorator('value', {
                  rules: [{ required: true, whitespace: true, message: "必填" }]
                })(
                  <Input size="small" type="text" />
                )
              }
            </FormItem>
          </div>
          <div className="form-row-multi-items">
            <FormItem label="字典值翻译">
              {
                getFieldDecorator('name', {
                  rules: [{ required: true, whitespace: true, message: "必填" }]
                })(
                  <Input size="small" type="text" />
                )
              }
            </FormItem>
            <FormItem label="字典英文值">
              {
                getFieldDecorator('enName', {
                  rules: [{ whitespace: true }]
                })(
                  <Input size="small" type="text" />
                )
              }
            </FormItem>
          </div>
        </div>
        <div className="form-btn-wrapper">
          <Button size="small" type="primary" htmlType="submit">提交</Button>
        </div>
      </Form>
    );
  }
}

const EditDictItemForm = Form.create({
  mapPropsToFields(props) {
    return Util.mapPropsToFields(props.dataSource);
  }
})(EditDictItemFormComponent);

export default EditDictItemForm;

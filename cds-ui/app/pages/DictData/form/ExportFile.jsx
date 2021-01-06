import React, { Component } from 'react';
import { Select } from '@gza/quantex-design';
import { Form, Button } from 'antd';
import { Util, DICTDATA } from 'utils';

const FormItem = Form.Item;
class ExportFileFormComponent extends Component {
  /**
   * 提交表单
   * @param e
   */
  handleSubmit = (e, type) => {
    e.preventDefault();
    const { form, store } = this.props;
    form.validateFields((err, value) => {
      if (!err) {
        let params = Util.buildFormData(value);
        store.exportFile({ appIds: params.appIds.toString() }, type);
      }
    });
  };

  render() {
    const { getFieldDecorator } = this.props.form;
    return (
      <Form className="form-content-wrapper">
        <div className="form-main-content">
          <FormItem label="所属应用">
              {
                getFieldDecorator('appIds', {
                  rules: [{ required: true, message: "必填" }]
                })(
                  <Select
                    allowClear={true}
                    mode='multiple'
                    dictSite='portal-server'
                    dictUrl='/api/v1/applications'
                  >
                  </Select>
                )
              }
            </FormItem>        
        </div>
        <div className="form-btn-wrapper">
          <Button className='m-r-10' size="small" type="primary" onClick={e => { this.handleSubmit(e, 'front') }}>前端导出</Button>
          <Button size="small" type="primary" onClick={e => { this.handleSubmit(e, 'back') }}>后端导出</Button>
        </div>
      </Form>
    );
  }
}

const ExportFileForm = Form.create({})(ExportFileFormComponent);

export default ExportFileForm;

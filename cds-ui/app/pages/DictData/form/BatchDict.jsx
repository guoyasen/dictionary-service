import React, { Component } from 'react';
import { Form, Input, Button, Icon, Checkbox } from 'antd';
import { Select } from '@gza/quantex-design';
import { observer } from 'mobx-react';
import { compact } from 'lodash';
import { Util, DICT, DICTDATA } from 'utils';

const FormItem = Form.Item;
/**
 * 批量编辑字典表单
 */
@observer
class BatchDictFormComponent extends Component {
  /**
   * 提交表单
   * @param e
   */
  handleSubmit = (e) => {
    e.preventDefault();
    const { form, store, type, dataSource } = this.props;
    form.validateFields((err, formData) => {
      if (!err) {
        formData.dictKey = formData.dictKey.trim();
        formData.appId = formData.appId.toString();
        formData.dicts = compact(formData.dicts);
        let params = Util.buildFormData(formData);
        if (type === 'add') {
          store.addDict(params);
        } else {
          params.id = dataSource.id;
          store.updateDict(params);
        }
      }
    });
  };

  /**
   * render 动态添加的字典值/字典值翻译组
   * @returns {Array}
   */
  renderDictGroup = () => {
    const { getFieldDecorator } = this.props.form;
    const { uiState } = this.props;
    // 样式
    const { newItemLayout } = this.getItemLayout();

    // 标记当前子字典个数
    let length = 0;
    uiState.dictItemKeys.forEach(item => {
      if (!item.removed) {
        length += 1;
      }
    });

    return uiState.dictItemKeys.slice().map((item) => {
      const key = item.key;
      // 获取对象数据结构
      const dictValueName = `dicts[${key}].value`; // 字典值
      const dictLabelName = `dicts[${key}].name`; // 字典值翻译
      const dictLabelEnName = `dicts[${key}].enName`; // 字典值英文名称
      const iconProps = {
        style: length === 1 ? {} : newItemLayout
      };
      // 若标记已被删除,则不渲染
      if (item.removed) return null;
      return (
        <div key={key} className="form-row-multi-items">
          <FormItem label="字典值">
            {getFieldDecorator(dictValueName, {
              rules: [{
                required: true,
                whitespace: true,
                message: "必填",
              }],
            })(
              <Input size="small" type="text" {...iconProps} />
            )}

          </FormItem>
          <FormItem label="字典值翻译">
            {getFieldDecorator(dictLabelName, {
              rules: [{
                required: true,
                whitespace: true,
                message: "必填",
              }],
            })(
              <Input size="small" type="text" {...iconProps} />
            )}
          </FormItem>
          <FormItem label="字典英文值">
            {getFieldDecorator(dictLabelEnName, {
              rules: [{
                required: true,
                whitespace: true,
                message: "必填",
              }],
            })(
              <Input size="small" type="text" {...iconProps} />
            )}
            {
              length === 1 ? null :
                <Icon className="dynamic-delete-button"
                  type="minus-circle"
                  onClick={() => { uiState.removeDictItem(key); }} />
            }
          </FormItem>
        </div>
      );
    });
  };
  /**
   * 获取表单样式
   * @private
   */
  getItemLayout() {
    // 新添加项样式
    const newItemLayout = {
      width: '85%',
      marginRight: 6
    };

    return {
      newItemLayout: newItemLayout
    };
  }

  render() {
    const { getFieldDecorator } = this.props.form;
    const { uiState, type } = this.props;

    return (
      <Form className="form-content-wrapper" onSubmit={this.handleSubmit}>
        <div className="form-main-content">
          <div className="form-row-multi-items">
            <FormItem label="字典key">
              {
                getFieldDecorator('dictKey', {
                  rules: [{ required: true, whitespace: true, message: '必填' }]
                })(
                  <Input size="small" type="text" disabled={type === 'edit'} />
                )
              }
            </FormItem>

            <FormItem label="字典名称">
              {getFieldDecorator('dictName', { rules: [{ required: true, whitespace: true, message: '必填' }] })(
                <Input size="small" type="text" />
              )}
            </FormItem>
          </div>

          <div className="form-row-multi-items">
            <FormItem label="字典值类型">
              {getFieldDecorator('dictValueType', {
                rules: [{ required: true, message: '必填' }],
                initialValue: DICT.cds_dict_value_type_string,
              })(
                <Select
                  allowClear={true}
                  dictData={DICTDATA.cds_dict_value_type}>
                </Select>
              )}
            </FormItem>
            <FormItem label="所属应用">
              {getFieldDecorator('appId', {
                rules: [{ required: true, message: '必填' }]
              })(
                <Select
                  allowClear={true}
                  disabled={type === 'edit'}
                  dictSite='portal-server'
                  dictUrl='/api/v1/applications/list'
                  dictParams={{ $query: false }}
                  dictConfig={{
                    optionIdProp: 'appId',
                    optionNameProp: 'appId'
                  }}
                >
                </Select>
              )}
            </FormItem>
          </div>

          <div className="form-row-multi-items">
            <FormItem label="备注">
              {
                getFieldDecorator('remark')(<Input.TextArea rows={1} />)
              }
            </FormItem>
          </div>

          <div className='m-b-8'>
            <a onClick={uiState.addDictItem}>添加字典子项</a>
          </div>         
          {this.renderDictGroup()}
        </div>

        <div className="form-btn-wrapper">
          <Button size="small" type="primary" htmlType="submit">提交</Button>
        </div>
      </Form>
    );
  }
}

const BatchDictForm = Form.create({
  mapPropsToFields(props) {
    return Util.mapPropsToFields(props.dataSource);
  }
})(BatchDictFormComponent);

export default BatchDictForm;

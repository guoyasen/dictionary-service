import { API, decorators } from '@gza/quantex-utils';

const { response } = decorators;

class Store {
  api = new API('cds-web');

  /**
   * 添加角色
   * @param formData
   */
  @response('添加成功')
  addPerInfo = formData => {
    return this.api.post('/persons', formData)
  };

  /**
   * 编辑角色
   * @param formData
   */
  @response('更新成功')
  updatePerInfo = formData => {
    const name = formData.name;
    return this.api.put(`/persons/${name}`, formData)
  };

  /**
   * 注销用户
   * @param params name
   */
  deletePerInfo = name => {
    return this.api.delete(`/persons/${name}`)
  }
}

export default Store;

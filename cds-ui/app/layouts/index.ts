import defaultLayouts from '@/containers/defaultLayouts';
import { cloneDeep } from 'lodash';
import { Util } from '@gza/quantex-utils';

// 这里需要先深拷贝一份配置
const layouts = cloneDeep(defaultLayouts);

/*
*  假设需要登录 GZA UI 系统，可以使用以下数据格式，所有字段不可更改：
*  {
*     code: "用户编码",
*     name: "用户名",
*     token : token
*  }
*/

layouts.login.login = async (params) => {
  params.loginPassword = Util.sha256Encode(params.loginPassword);
  return Promise.resolve({
    code: 200,
    data: {
      code: 'test',
      name: 'test',
      token: 'eyJhbGciOiJIUzI1NiIsInR5cCI6I...6MTU4NzQzNTc2NX0.I5McYxR4y0luSTWeaFGDmV',
    },
    msg: '操作成功！',
  });
};

// 此处只做覆盖，不做任何逻辑
layouts.login.logout = async () => {
  return Promise.resolve();
};

// 此处只做覆盖，不做任何逻辑
layouts.login.getMicroApp = () => {
  return Promise.resolve({ code: 200, data: { list: [] } });
};

layouts.login.getUserButton = () => {
  return Promise.resolve([]);
};
/*
* GZA UI 系统菜单数据，可以使用以下格式，所有字段不可更改：
* 若是一级菜单需要按照以下格式，且父子菜单ID需要一致：
* {
*    id: 子菜单ID,
*    pId: 父菜单ID,
*    icon: 菜单图标, （一级菜单需要）
*    appId: APP ID,
*    name: 菜单名称
* }
* 若不是是一级菜单需要按照以下格式：
* {
*    id: 子菜单ID,
*    pId: 父菜单ID,
*    appId: APP ID,
*    name: 菜单名称
*    url: 菜单地址,  （子菜单需要，appId/路径，路径是相对于 app/pages 的路径）
* }
*/

layouts.main.getUserMenu = () => {
  return Promise.resolve({
    code: 200,
    data: {
      list: [
        {
          id: 1,
          pId: 1,
          icon: 'chanpinguanli',
          appId: 'cds',
          name: '人员管理',
          url: 'cds/Person',
        },
        {
          id: 2,
          pId: 2,
          icon: 'chanpinguanli',
          appId: 'cds',
          name: 'Portal 测试',
          url: 'cds/TestPage',
        },
        {
          id: 3,
          pId: 3,
          icon: 'chanpinguanli',
          appId: 'cds',
          name: '字典管理',
          url: 'cds/DictData',
        },
      ],
    },
    msg: '操作成功！',
  });
};

layouts.sider = {
  workBench: {
    hidden: false,
  },
  menu: {
    hidden: false
  }
}

export default layouts;

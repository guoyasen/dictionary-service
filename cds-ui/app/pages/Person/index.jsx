import React from 'react';
import { Popconfirm, Button } from 'antd';
import { observer } from 'mobx-react';
import { AButton, Aa, Modal, AgGrid, Alert } from '@gza/quantex-design';
import RoleForm from './Form';
import Store from './Store';
import 'antd/lib/pagination/style';

@observer
class RoleComponent extends React.Component {
  modal = new Modal.Store();
  store = new Store(this.modal);
  constructor(props) {
    super(props);
    this.initAgGird();
  }

  /**
   * 编辑个人信息
   */
  showEditForm = record => {
    const bar = (
      <RoleForm
        type="edit"
        dataSource={record}
        store={this.store}
        originData={{ name: record.name }}
        onClose={this.onClose}
        handleRloadTable={this.handleRloadTable}
      />
    );
    this.modal.openForm('编辑信息', bar);
  };

  onClose = () => {
    this.modal.close();
  };

  /**
   * 添加个人信息
   */
  showAddForm = () => {
    const bar = (
      <RoleForm
        store={this.store}
        type="add"
        onClose={this.onClose}
        handleRloadTable={this.handleRloadTable}
      />
    );
    this.modal.openForm('添加信息', bar);
  };

  /**
   *删除个人信息
   */
  deletePerInfo = async record => {
    const res = await this.store.deletePerInfo(record.name);
    if (res.code == 200) {
      Alert.success('删除成功');
      this.tableStore?.reload();
    } else {
      Alert.error(res.msg);
    }
  };

  handleRloadTable = () => {
    this.tableStore?.reload();
  };

  initAgGird = () => {
    this.searchApi = AgGrid.createSearchApi({
      api: 'cds-web',
      url: '/persons',
      method: 'query',
    });
    this.formConfig = {
      fields: [
        {
          name: 'name$like',
          label: '姓名',
          component: 'Input',
          props: {
            allowClear: true,
          },
        },
        {
          name: 'number$like',
          label: '电话',
          component: 'Input',
          props: {
            allowClear: true,
          },
        },
      ],
    };
    this.tableConfig = {
      tableId: AgGrid.Table.ID.Person_index,
      // 各列配置
      props: {
        columnDefs: [
          {
            headerName: '姓名',
            field: 'name',
          },
          {
            headerName: '年龄',
            field: 'age',
          },
          {
            headerName: '性别',
            colId: 'gender',
            valueFormatter: ({ data }) => {
              return data?.gender == 1 ? '男' : '女';
            },
          },
          {
            headerName: '电话',
            field: 'number',
          },
          {
            headerName: '操作',
            colId: 'operation',
            width: 145,
            filter: false,
            sortable: false,
            cellRendererFramework: ({ data = {} }) => {
              return (
                <div>
                  <Aa
                    className="m-r-8"
                    onClick={() => {
                      this.showEditForm(data);
                    }}>
                    编辑
                  </Aa>
                  <Popconfirm
                    className="m-r-8"
                    title="确定删除?"
                    onConfirm={() => {
                      this.deletePerInfo(data);
                    }}>
                    <Aa>删除</Aa>
                  </Popconfirm>
                </div>
              );
            },
          },
        ],
        defaultColDef: {
          resizable: true,
          sortable: true,
          filter: 'agTextColumnFilter',
          filterParams: {
            caseSensitive: true,
            newRowsAction: 'keep',
            applyButton: true,
          },
        },
        rowModelType: 'serverSide',
        pagination: true,
        paginationPageSize: 20,
      },
      onTableReady: tableStore => {
        this.tableStore = tableStore;
        this.gridApi = tableStore.getGridApi();
      },
    };
  };
  // 表格配置

  render() {
    return (
      <>
        <div className="qx-main">
          <AgGrid.SearchFormTable
            formConfig={this.formConfig}
            searchApi={this.searchApi}
            tableConfig={this.tableConfig}>
            <AButton size="small" type="primary" onClick={this.showAddForm}>
              添加人员
            </AButton>
          </AgGrid.SearchFormTable>
        </div>
        <Modal {...this.modal.props} />
      </>
    );
  }
}

export default RoleComponent;

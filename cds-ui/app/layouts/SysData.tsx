import React from 'react';
import { observer } from 'mobx-react';
import moment from 'moment';
import Store from './Store';
const styles = require('./index.scss');

@observer
class SysDate extends React.Component {
  store = new Store();

  constructor(props: any) {
    super(props);
    this.state = {
      date: 0,
    };
  }

  getSystemDate = async () => {
    const res = await this.store.getSystemDate();
    window.localStorage.setItem('systemDate', res);
    this.setState(() => ({
      date: res
    }))
  };

  componentDidMount() {
    this.getSystemDate();
  }

  render() {
    const date = moment(this.state.date).format('YYYY-MM-DD');
    return (
      <div className={styles['sys-date']}>
        <span>
          系统日期：
          {date}{' '}
        </span>
      </div>
    );
  }
}

export default SysDate;

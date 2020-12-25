import React, { useState, useEffect } from 'react';
import Store from './Store';
import { Alert } from '@gza/quantex-design';
import style from './style.scss';

const Test: React.FC = () => {
  const store = new Store();
  const [name, setName] = useState();
  const getUser = async () => {
    const res: any = await store.getUserName();
    if (res.code == 200) {
      setName(res.data);
    } else {
      Alert.error(res.msg);
    }
  };
  useEffect(() => {
    getUser();
  }, []);
  return (
    <div className={style.center}>
      <div style={{fontSize: "18px"}}>当前登录用户: {name}</div>
    </div>
  );
};

export default Test;

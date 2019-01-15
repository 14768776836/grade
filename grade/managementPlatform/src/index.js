import React from 'react';
import ReactDOM from 'react-dom';
import 'antd/dist/antd.min.css';
import './assets/css/index.css';
// 多国语言
import { LocaleProvider } from 'antd';
import zh_CN from 'antd/lib/locale-provider/zh_CN';
import 'moment/locale/zh-cn';

import App from './app/App';
import * as serviceWorker from './serviceWorker';

ReactDOM.render(<LocaleProvider locale={zh_CN}><App /></LocaleProvider>, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
serviceWorker.unregister();



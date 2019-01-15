import React, {Component} from 'react';
import {
	message,
	Upload,
	Button,
	Icon
} from 'antd';
import {
	Redirect,
	Link
} from 'react-router-dom';


class UploadFile extends Component {

	constructor (props) {
		super(props);

	}
	componentWillMount () {
		console.log('组件将要被渲染，适合做数据操作！');
	}
	componentDidMount () {
		localStorage.removeItem('formValues');
		console.log('DOM树渲染完成，数据接入！');
	}
	
	render () {
		const uploadConfig = {}
		return (
			<div className='uploadBox'>
				{/*<Upload {...uploadConfig}>
							    	<Button>
							      		<Icon type="upload" /> 上传文件
							    	</Button>
							 	</Upload>*/}
			</div>
		);
	}
}

export default UploadFile;

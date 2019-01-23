import React,{Component} from 'react';

import {
	message
} from 'antd';
import {
	Redirect,
	Link
} from 'react-router-dom';
import './../assets/css/makeMoney.css';

import ReactPullLoad ,{ STATS } from 'react-pullload';
/*import HeadNode from './../components/toUpdate/HeadNode';
import FooterNode from './../components/toUpdate/FooterNode';
import './../components/toUpdate/ReactPullLoad.css';*/
import HeadNode from './../../node_modules/react-pullload/dist/HeadNode';
import FooterNode from './../../node_modules/react-pullload/dist/FooterNode';
import './../../node_modules/react-pullload/dist/ReactPullLoad.css';


class ChildLists extends Component {
	constructor (props) {
		super(props);
		this.state = {
			userId       : null,
			pageNum      : 1,
			pageLast     : 0,
			datas        : [],
			// 上滑、下拉
			hasMore      : true,
	      	action       : STATS.init
		}
	}
	componentDidMount () {
		this.getChildLists();

	}
	getChildLists = (num) => {
		const self = this,
			pageNum = num? num : self.state.pageNum,
			userId = JSON.parse((localStorage.getItem('userMsg'))).user.id;

		// userId = JSON.parse(JSON.stringify({"success":true,"user":{"id":15,"username":"admin","telno":null,"extensionCode":"ID15PSNDZM","parentCode":"","faction":"","truename":"","loginPswd":"e10adc3949ba59abbe56e057f20f883e","payPswd":"e10adc3949ba59abbe56e057f20f883e","noPrice":900,"isPrice":100,"gmtCreate":"2018-11-28T13:13:14.000+0000","gmtModified":"2018-12-25T06:51:49.000+0000","userType":0,"userStatus":1,"token":"6c661b6a0c717a065427c8a64d5f5ba3","isDel":0},"parentUser":""})).user.id;
		
		fetch('/user/findChildrenList?userId='+userId+'&pageNum='+pageNum)
		.then(res => res.json())
		.then(data => {
			/*let data1 = this.state.datas;
			data1.childrenUserList.pageNum = 2;
			data1.*/
			// var datas = {"childrenUserList":{"pageNum":1,"pageSize":10,"size":7,"orderBy":null,"startRow":1,"endRow":7,"total":7,"pages":1,"list":[{"id":45,"username":"ts18069791015","telno":null,"extensionCode":"ID45QFJTRX","parentCode":"ID15PSNDZM","faction":null,"truename":"","loginPswd":"e10adc3949ba59abbe56e057f20f883e","payPswd":null,"noPrice":0.00,"isPrice":0.00,"gmtCreate":"2018-12-29T04:51:56.000+0000","gmtModified":null,"userType":0,"userStatus":null,"token":"fdc7c4d704dbda86fb9a35c7941e73b0","isDel":0},{"id":44,"username":"sunnh","telno":null,"extensionCode":"ID44RREOFM","parentCode":"ID15PSNDZM","faction":null,"truename":"","loginPswd":"e10adc3949ba59abbe56e057f20f883e","payPswd":null,"noPrice":0.00,"isPrice":0.00,"gmtCreate":"2018-12-26T17:04:10.000+0000","gmtModified":null,"userType":0,"userStatus":null,"token":"60cf88b31276bfcf7eda5caf71191588","isDel":0},{"id":43,"username":"zzcn77","telno":null,"extensionCode":"ID43QYYRUS","parentCode":"ID15PSNDZM","faction":null,"truename":"","loginPswd":"e10adc3949ba59abbe56e057f20f883e","payPswd":null,"noPrice":0.00,"isPrice":0.00,"gmtCreate":"2018-12-26T05:34:59.000+0000","gmtModified":null,"userType":0,"userStatus":null,"token":"5500a8e2f94dcd80c090ef05b0895594","isDel":0},{"id":42,"username":"sunnyboy8888","telno":null,"extensionCode":"ID42ROJZDT","parentCode":"ID15PSNDZM","faction":"","truename":"","loginPswd":"e10adc3949ba59abbe56e057f20f883e","payPswd":null,"noPrice":0.00,"isPrice":0.00,"gmtCreate":"2018-12-24T22:47:52.000+0000","gmtModified":null,"userType":1,"userStatus":null,"token":"982c904b81008f7df25d4ba32ee957fb","isDel":0},{"id":39,"username":"ege123","telno":null,"extensionCode":"ID39SMLEBP","parentCode":"ID15PSNDZM","faction":null,"truename":"","loginPswd":"e10adc3949ba59abbe56e057f20f883e","payPswd":null,"noPrice":0.00,"isPrice":0.00,"gmtCreate":"2018-12-09T08:56:03.000+0000","gmtModified":null,"userType":0,"userStatus":null,"token":"863fed7fd43cfabbd06d29f96ed48cfe","isDel":0},{"id":38,"username":"255","telno":null,"extensionCode":"ID38GZPXKB","parentCode":"ID15PSNDZM","faction":null,"truename":"","loginPswd":"e10adc3949ba59abbe56e057f20f883e","payPswd":null,"noPrice":0.00,"isPrice":0.00,"gmtCreate":"2018-12-09T08:31:25.000+0000","gmtModified":null,"userType":0,"userStatus":null,"token":"03fd72431ff77f632fd58114795afb27","isDel":0},{"id":16,"username":"han","telno":null,"extensionCode":"ID16RCWBKW","parentCode":"ID15PSNDZM","faction":null,"truename":"","loginPswd":"e10adc3949ba59abbe56e057f20f883e","payPswd":null,"noPrice":0.00,"isPrice":0.00,"gmtCreate":"2018-12-03T08:58:15.000+0000","gmtModified":null,"userType":0,"userStatus":null,"token":"a466f11f1c385411eaee56b8003aee6e","isDel":0}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1]},"success":true};
			if (data.success) {
				if (this.state.pageLast && this.state.pageLast < 10) {
					message.info('已加载全部内容！');
					return;
				}
				let datas = num ? this.state.datas.concat(data.childrenUserList.list)
								: data.childrenUserList.list;
				const accountLists = datas.map((v,inx)=>{
					return <div className='accountList' key={v.id}>
						<p>用户名&nbsp;&nbsp;&nbsp;&nbsp;：{v.username}</p>
						<p>创建时间：{this.chinaTime(v.gmtCreate)}</p>
					</div>
				});
				self.setState({
					userId       : userId,
					accountLists : accountLists,
					datas        : datas,
					pageLast     : data.childrenUserList.size
				})
			} else {
				message.error(data.msg);
			}
		});
	}
	/* 状态处理 */
	handleAction = (action) => {
	    console.info(action, this.state.action,action === this.state.action);
	    if(action === this.state.action){
	       return false
	    }
	    if(action === STATS.refreshing){//刷新
	       	this.handRefreshing();
	    } else if(action === STATS.loading){//加载更多
	       	this.handLoadMore();
	    } else{
	        this.setState({
	          	action: action
	       	})
	    }
	}
	/* 是否'刷新'状态 */
	handRefreshing = () => {
		if(STATS.refreshing === this.state.action){
	      	return false
	    }
	    // var data2 = {"childrenUserList":{"pageNum":2,"pageSize":10,"size":3,"orderBy":null,"startRow":11,"endRow":13,"total":13,"pages":2,"list":[{"id":39,"username":"ege123","telno":null,"extensionCode":"ID39SMLEBP","parentCode":"ID15PSNDZM","faction":null,"truename":"","loginPswd":"e10adc3949ba59abbe56e057f20f883e","payPswd":null,"noPrice":0.00,"isPrice":0.00,"gmtCreate":"2018-12-09T08:56:03.000+0000","gmtModified":null,"userType":0,"userStatus":null,"token":"863fed7fd43cfabbd06d29f96ed48cfe","isDel":0},{"id":38,"username":"255","telno":null,"extensionCode":"ID38GZPXKB","parentCode":"ID15PSNDZM","faction":null,"truename":"","loginPswd":"e10adc3949ba59abbe56e057f20f883e","payPswd":null,"noPrice":0.00,"isPrice":0.00,"gmtCreate":"2018-12-09T08:31:25.000+0000","gmtModified":null,"userType":0,"userStatus":null,"token":"03fd72431ff77f632fd58114795afb27","isDel":0},{"id":16,"username":"han","telno":null,"extensionCode":"ID16RCWBKW","parentCode":"ID15PSNDZM","faction":null,"truename":"","loginPswd":"e10adc3949ba59abbe56e057f20f883e","payPswd":null,"noPrice":0.00,"isPrice":0.00,"gmtCreate":"2018-12-03T08:58:15.000+0000","gmtModified":null,"userType":0,"userStatus":null,"token":"a466f11f1c385411eaee56b8003aee6e","isDel":0}],"firstPage":1,"prePage":1,"nextPage":0,"lastPage":2,"isFirstPage":false,"isLastPage":true,"hasPreviousPage":true,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1,2]},"success":true};


	    let timer = setTimeout(()=>{
	     	this.setState({
		        hasMore: true,
		        action: STATS.refreshed,
	      	});
	      	clearTimeout(timer);
	    }, 1500)

	    this.setState({
	      	action: STATS.refreshing
	    });	
	}
	/* 是否'更多'状态,'更多'状态处理 */
	handLoadMore = () => {
		if(STATS.loading === this.state.action){
	      	return false
	    }

	    let timer = setTimeout( () => {
	      	if(this.state.index === 0){
	        	this.setState({
	          		action: STATS.reset,
	          		hasMore: false
	        	});
      		} else{
      			let pageNum = this.state.pageNum;
      			pageNum++;
		        this.setState({
		         	action: STATS.reset,
		          	pageNum: pageNum
		        });
		        console.log('---------pageNum---',pageNum)
		        this.getChildLists(pageNum);
	      	}
	      	clearTimeout(timer);
	    }, 1500);

	    this.setState({
	      action: STATS.loading
	    })
	}
	/* 时间转换
	*  国际标准时间 ===> 中国标准时间
	*  @param  timeStr 国际标准时间字符串; （'2018-12-29T04:51:56.000+0000'）
	*  @return yyyy-mm-dd xx-xx-xx
	*/	
	chinaTime = (timeStr) => {
		function isAddZero (num) {
			num = parseInt(num);
			if (num < 10) {
				return `0${num}`;
			} 
			if (num >= 10) {
				return num;
			} 
		}
		let date = new Date(timeStr),
		yy = date.getFullYear(),
		mm = date.getMonth() + 1,
		dd = date.getDate(),
		hh = date.getHours() + 1,
		mimi = date.getMinutes() + 1,
		ss = date.getSeconds() + 1,
		dateStr = `${isAddZero(yy)}-${isAddZero(mm)}-${isAddZero(dd)} ${isAddZero(hh)}:${isAddZero(mimi)}:${isAddZero(ss)}`;
		return dateStr;
	}
	render () {
		const { 
			accountLists , 
			datas,
			action,
			hasMore
		} = this.state;
		const overdueDate = localStorage.getItem('overdueDate');
		if (!overdueDate) {
			message.warning('登录失效，请重新登录！');
            return <Redirect push to={'/login'} />
		}

		return (
			<div className='childLists'>
				<div className='returnBox'><Link to='' className='returnBtn'>返回</Link></div>
				<div className='accountBox'>
					{/*<PullRefresh datas={datas} parentName='childLists' />*/}
					<ReactPullLoad 
			          	downEnough={100}
			          	action={action}
			          	handleAction={this.handleAction}
			          	hasMore={hasMore}
			          	distanceBottom={100}
			          	HeadNode={HeadNode}
			          	FooterNode={FooterNode}
			        >
			          	<ul className='listsBox' style={{paddingLeft: 0}}>
			            	{accountLists}
			          	</ul>
			        </ReactPullLoad>
				</div>
			</div>
		)
	}
}

export default ChildLists;
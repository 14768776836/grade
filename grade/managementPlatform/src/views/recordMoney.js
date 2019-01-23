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


class RecordMoney extends Component {
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
		const params = `
			userId=${userId}&
			pageNum=${pageNum}
		`;
		fetch(`/order/getCollectionRecord?${params}`)
		.then(res => res.json())
		.then(data => {
			if (data.success) {
				if (this.state.pageLast && this.state.pageLast < 10 && STATS.refreshing === this.state.action) {
					message.info('已加载全部内容！');
					return;
				}
				let datas = num ? this.state.datas.concat(data.orders.list)
								: data.orders.list;
				const accountLists = datas.map((v,inx)=>{
					return <div className='accountList' key={v.id}>
						<p>用户名&nbsp;&nbsp;&nbsp;&nbsp;：{v.wxUserName}</p>
						<p>收款金额：{v.payPrice}元</p>
						<p>创建时间：{this.chinaTime(v.gmtCreate)}</p>
					</div>
				});
				self.setState({
					userId       : userId,
					accountLists : accountLists,
					datas        : datas,
					pageLast     : data.orders.size
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
	    let timer = setTimeout(()=>{
	     	this.setState({
		        pageLast: 0,
				datas   : [],
		        hasMore: true,
		        action: STATS.refreshed,
	      	});
	      	this.getChildLists(1);
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

export default RecordMoney;
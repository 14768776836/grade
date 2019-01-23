import React, {Component} from 'react';
import {
	Button,
	Checkbox,
	message
} from 'antd';
import { Redirect ,Link } from 'react-router-dom';
import ReactPullLoad ,{ STATS } from 'react-pullload';
/*import HeadNode from './../components/toUpdate/HeadNode';
import FooterNode from './../components/toUpdate/FooterNode';
import './../components/toUpdate/ReactPullLoad.css';*/
import HeadNode from './../../node_modules/react-pullload/dist/HeadNode';
import FooterNode from './../../node_modules/react-pullload/dist/FooterNode';
import './../../node_modules/react-pullload/dist/ReactPullLoad.css';
import './../assets/css/remit.css';
import throttle from 'lodash.throttle';

message.config({
	duration: 3
});
const CheckboxGroup = Checkbox.Group;



class RemitCom extends Component {
	state = {	
		checkAll     : true, // 是否全选
		// checkAll     : false, // 是否全选
		checkedList  : [],   // 默认选中的列表
		optionsList  : [],   // 可选择的选项
		userId       : JSON.parse(localStorage.getItem('userMsg')).user.id,
		pageNum      : 1,
		isGoPay      : true, // 打款按钮是否可用
		// data.orders.list数据，属性名为wxUserName
		checkedListAllData: {},
		// wxUserName集合所对应的订单id
		ordersId     : [],
		alreadyPaid  : false,

		pageNum      : 1,
		pageLast     : 0,
		// 上滑、下拉
		hasMore      : true,
      	action       : STATS.init
	}
	constructor () {
		super();
		let overdueDate = localStorage.getItem('overdueDate');
		if (new Date(Number(overdueDate)).getTime() < new Date().getTime()) {
			localStorage.removeItem('overdueDate');
		}
		this.searchListsByStatus = throttle(this.searchListsByStatus,2500);
	}
	componentDidMount () {
		this.getData();
	}
	componentWillUnmount () {
		this.searchListsByStatus.cancel();
	}
	/* 获取打款人列表---首先拿到的是最近一期的 */
	getData = (num) => {
		const { userId } = this.state;
		let pageNum;
		if (num) {
			pageNum = num;
		} else {
			pageNum = this.state.pageNum;
		}
		fetch(`/order/getOrderList?userId=${userId}&pageNum=${pageNum}`)
		.then( res => res.json())
		.then( data => {
			if (data.success) {

				/*// 测试数据开始------
				let checkedList = ['第一项','第二项','第三项','第四项'];
				this.setState({
					checkedList: checkedList,
					optionsList: checkedList
				})
				// 测试数据结束------*/

				this.severData(data,num);
			}
		})
	}
	/* 分离数据 */
	severData = (data,num) => {
		let payStatus = ['支付成功','未绑定公众号','数据丢失','订单异常','未支付'];
		var checkedListAllData = {},
			  wxUserNameArr = [],
			  wxUserNameArrNo = [],// 当前可以选择的
			  ordersId = [];
		if (data.orders.list === null || !data.orders.list) {
			this.setState({
				checkedList: [],
				optionsList: [],
				ordersId   : [],
				checkedListAllData: {}
			})
			return;
		}
		if (num && data.orders.total <= this.state.optionsList.length && STATS.refreshing === this.state.action) {
			message.info('已无更多数据！');
			return
		}
		// 微信名称arr、整体数据列表arr
		let i = 0;
		for (let ele of data.orders.list) {
			/*checkedListAllData[`${ele.wxUserName}(状态：${payStatus[ele.payStatus]})`] = ele;
			wxUserNameArr.push(`${ele.wxUserName}(状态：${payStatus[ele.payStatus]})`);
			if (ele.isCertification === 0) {
				ordersId.push(ele.id);
				// 公众号已经注册
				wxUserNameArrNo.push(ele.wxUserName);
			}
			*/
			// 测试数据开始---
			checkedListAllData[`${ele.wxUserName}(状态：${payStatus[ele.payStatus]})---${i}`] = ele;
			wxUserNameArr.push(`${ele.wxUserName}(状态：${payStatus[ele.payStatus]})---${i}`);
			if (ele.isCertification === 0) {
				ordersId.push(ele.id);
				// 公众号已经注册
				wxUserNameArrNo.push(`${ele.wxUserName}(状态：${payStatus[ele.payStatus]})---${i}`);
			}
			i++;
			// 测试数据结束---
		}
		// 加载更多
		if (num) {
			wxUserNameArrNo = this.state.checkedList.concat(wxUserNameArrNo);
			wxUserNameArr = this.state.optionsList.concat(wxUserNameArr);
			ordersId = this.state.ordersId.concat(ordersId);
			checkedListAllData = Object.assign(checkedListAllData,this.state.checkedListAllData)
		}
		console.log('默认选中的---',wxUserNameArrNo)
		this.setState({
			checkedList: wxUserNameArrNo,
			optionsList: wxUserNameArr,
			ordersId   : ordersId,
			checkedListAllData: checkedListAllData
		})
	}
	/* 全选 */
	handleCheckAll = (e) => {
		this.setState({
			checkedList  : e.target.checked ? this.state.optionsList : [],
	  		checkAll     : e.target.checked,
		});
	}
	/* 单个选择 */
	groupChange = (checkedList) => {
		let ordersId = [];
		const { 
			optionsList ,
			checkedListAllData,
		} = this.state;
		for (let ele of checkedList) {
			ordersId.push(checkedListAllData[ele].id);
		}
		this.setState({
			checkedList,
		  	checkAll: checkedList.length === optionsList.length,
		  	ordersId: [...new Set(ordersId)]
		});
	}
	/* 查询不同状态的订单 
	 * @param status 0-已经支付；4：未支付
	*/
	searchListsByStatus = (status) => {
		console.log(status)
		let alreadyPaid = status ? false : true;
		this.setState({
			alreadyPaid : alreadyPaid,
			isGoPay     : status,
			checkedList: [],
			optionsList: [],
			ordersId   : [],
			checkedListAllData: {}
		});
		fetch(`/order/getSpecificOrderList?userId=${this.state.userId}&pageNum=${this.state.pageNum}&payStatus=${status}`)
		.then( res => res.json())
		.then( data => {
			if (data.success) {
				this.severData(data);
			}
		})
	}	
	/* 开始打款 */
	handleSubmit = (e) => {



		console.log(this.state.ordersId)



		e.preventDefault();
		let self = this;
		/*fetch(`/order/pay?userId=${this.state.userId}&orders=${this.state.ordersId}`)
		.then(res => res.json())
		.then(data => {
			if (data.success) {
				message.success('打款成功！');
				if (this.state.ordersId.length === this.state.checkedList.length) {
					let timer = setTimeout(function(){
						message.warning('公众号未注册的用户未打款，详情查看未打款！');
						clearTimeout(timer);
					},3000);
				}
				this.getData();
				this.setState({
					ordersId: []
				})
			}
		})*/
	}
	/* 上滑、下拉状态处理 */
	handleAction = (action) => {
	    // console.info(action, this.state.action,action === this.state.action);
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
		        hasMore: true,
		        action: STATS.refreshed,
		        ordersId: [],
		        optionsList: [],
		        checkedList: []
	      	});
	      	this.getData(1);
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
		        this.getData(pageNum);
	      	}
	      	clearTimeout(timer);
	    }, 1500);

	    this.setState({
	      action: STATS.loading
	    })
	}
	render () {
		const { 
			optionsList ,
			checkedList ,
			checkAll,
			isGoPay,
			alreadyPaid,
			action,
			hasMore,
		} = this.state;
		const overdueDate = localStorage.getItem('overdueDate');
		if (!overdueDate) {
			message.warning('登录失效，请重新登录！');
            return <Redirect push to={'/login'}/>
		}

		return (
			<div className='remitBox'>
				<div className='returnBox'>
					<Link to='' className='returnBtn'>返回</Link>
					<strong style={{lineHeight: '3rem',color: 'red'}}>提示：未绑定微信公众号或者订单状态异常请谨慎打款</strong>
					<div className='searchBtnBox'>
						<Button className='btn' onClick={()=>this.searchListsByStatus(4)}>未打款</Button>
						<Button className='btn' onClick={()=>this.searchListsByStatus(0)}>已打款</Button>
					</div>
				</div>
				<div className='checkBox'>
					<Checkbox
						onChange={this.handleCheckAll}
						checked={checkAll}
						disabled={alreadyPaid}
					>全选</Checkbox>
					<ReactPullLoad
						downEnough={100}
						action={action}
						hasMore={hasMore}
						handleAction={this.handleAction}
						distanceBottom={100}
						HeadNode={HeadNode}
						FooterNode={FooterNode}
					>
			          	<div className='listsBox' style={{paddingLeft: 0}}>
							<CheckboxGroup options={optionsList} value={checkedList} onChange={this.groupChange} disabled={alreadyPaid}></CheckboxGroup>
			          	</div>
					</ReactPullLoad>
					<Button disabled={!isGoPay || !checkedList.length} className='remitBtn' onClick={this.handleSubmit}>开始打款</Button>
				</div>
			</div>
		)
	}
}
export default RemitCom;


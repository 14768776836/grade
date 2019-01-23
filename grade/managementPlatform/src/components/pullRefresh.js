/*
* react-pullload：
* 1、handleAction ，handLoadMore 和 handRefreshing 只是在更改action；
*/
import React, {Component} from 'react';
import ReactPullLoad ,{STATS} from 'react-pullload';



class PullRefreshCom extends Component {
	constructor (props) {
		super(props);
		this.state = {
	      	hasMore    : true,
	      	data       : props.datas,
	      	action     : STATS.init,
	      	parentName : null,
	      	pageNum    : null,

	      	test: props.test
	      	// index: loadMoreLimitNum //loading more test time limit
	    }
	    console.log(props.test)
	}
	componentDidMount () {

	}
	/* 接收更新到props ,react17版之前有用*/
	componentWillReceiveProps (nextProps) {
		this.setState({
			data      : nextProps.datas,
			parentName: nextProps.parentName
		})
	}
	/* 状态处理 */
	handleAction = (action) => {
	    // console.info(action, this.state.action,action === this.state.action);
	    if(action === this.state.action){
	       return false
	    }
	    if(action === STATS.refreshing){//刷新
	       	this.handRefreshing();

	       	this.state.test(this.state.data.childrenUserList.pageNum + 1);


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


	    var data2 = {"childrenUserList":{"pageNum":2,"pageSize":10,"size":3,"orderBy":null,"startRow":11,"endRow":13,"total":13,"pages":2,"list":[{"id":39,"username":"ege123","telno":null,"extensionCode":"ID39SMLEBP","parentCode":"ID15PSNDZM","faction":null,"truename":"","loginPswd":"e10adc3949ba59abbe56e057f20f883e","payPswd":null,"noPrice":0.00,"isPrice":0.00,"gmtCreate":"2018-12-09T08:56:03.000+0000","gmtModified":null,"userType":0,"userStatus":null,"token":"863fed7fd43cfabbd06d29f96ed48cfe","isDel":0},{"id":38,"username":"255","telno":null,"extensionCode":"ID38GZPXKB","parentCode":"ID15PSNDZM","faction":null,"truename":"","loginPswd":"e10adc3949ba59abbe56e057f20f883e","payPswd":null,"noPrice":0.00,"isPrice":0.00,"gmtCreate":"2018-12-09T08:31:25.000+0000","gmtModified":null,"userType":0,"userStatus":null,"token":"03fd72431ff77f632fd58114795afb27","isDel":0},{"id":16,"username":"han","telno":null,"extensionCode":"ID16RCWBKW","parentCode":"ID15PSNDZM","faction":null,"truename":"","loginPswd":"e10adc3949ba59abbe56e057f20f883e","payPswd":null,"noPrice":0.00,"isPrice":0.00,"gmtCreate":"2018-12-03T08:58:15.000+0000","gmtModified":null,"userType":0,"userStatus":null,"token":"a466f11f1c385411eaee56b8003aee6e","isDel":0}],"firstPage":1,"prePage":1,"nextPage":0,"lastPage":2,"isFirstPage":false,"isLastPage":true,"hasPreviousPage":true,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1,2]},"success":true};


	    setTimeout(()=>{
	      //refreshing complete
	     	this.setState({
		        data: this.state.data,
		        hasMore: true,
		        action: STATS.refreshed,
	      	});
	    }, 3000)

	    this.setState({
	      	action: STATS.refreshing
	    });	
	}
	/* 是否'更多'状态,'更多'状态处理 */
	handLoadMore = () => {
		/*if(STATS.loading === this.state.action){
	      	return false
	    }

	    setTimeout(()=>{
	      	if(this.state.index === 0){
	        	this.setState({
	          		action: STATS.reset,
	          		hasMore: false
	        	});
      		} else{
		        this.setState({
		          	data: [...this.state.data, cData[0], cData[0]],
		         	action: STATS.reset,
		          	index: this.state.index - 1
		        });
	      	}
	    }, 3000)

	    this.setState({
	      action: STATS.loading
	    })*/
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
			action,
			hasMore,
			data,
			parentName
		} = this.state;
		let lists,
		listsObj = {
			// 下级列表
			childLists: (() => {
				console.log(data)
				if (data===null) {return}
				return data.childrenUserList.list.map((v,inx)=>{
					return <li className='accountList' key={v.id}>
						<p>用户名：{v.username}</p>
						<p>创建时间&nbsp;&nbsp;&nbsp;&nbsp;：{this.chinaTime(v.gmtCreate)}</p>
					</li>
				});
			})(),
			
		};
		return (
			<div>
				<ReactPullLoad 
		          	downEnough={100}
		          	action={action}
		          	handleAction={this.handleAction}
		          	hasMore={hasMore}
		          	distanceBottom={100}>
		          	<ul className='listsBox' style={{paddingLeft: 0}}>
		            	{listsObj[parentName]}
		          	</ul>
		        </ReactPullLoad>
			</div>
		);
	}
}


export default PullRefreshCom;


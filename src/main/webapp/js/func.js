$.extend($.fn.validatebox.defaults.rules,{
	minLength:{
		validator:function(val,params){
		return val.length>=params[0];
		},
		message:"长度至少{0}位"
	},
	checkLength:{
		validator:function(val,params){
		return val.length==params[0];
		},
		message:"长度必须{0}位"
	},

	telphonelength:{
		validator:function(val,params){
		return val.length==params[0];
		},
		message:"长度必须{0}位"
	},
	
	isNum:{
		validator:function(val){
			return !isNaN(val);
		},
		message:"必须是数字"
		},

	isEquals:{
		validator:function(val,params){
			var inputText=$(params[0]).val();
			return inputText==val;
		},
		message:"两次输入必须一样！！"
	}
	});
//日期
$.extend($.fn.datebox.defaults.formatter=function(date){
	var year = date.getFullYear();
	var month = date.getMonth()+1;
	var day = date.getDate();
	return year+"/"+month+"/"+day;
});
$.extend($.fn.datebox.defaults.parser=function(s){
	var t = Date.parse(s);
	if(!isNaN(t)){
		return new Date(t);
	}else{
		return new Date();
	}
	
	
});
$.getJSON("/testjson.json?callback=?", function(result){
//response data are now in the result variable
   alert(JSON.stringify(result, null, 4));
});

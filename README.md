# WebRequest
Library for easy work with web requests (modified Volley)

Gradle:
```
	compile 'com.github.fellowcode:WebRequest:0.0.4'
    compile 'com.android.volley:volley:1.0.0'
```

For start need make request listener, response - content html:
```java
	RespListener listener = new RespListener() {
				@Override
				public void onResponse(String response) {
					//your code
				}
			};
```

Send request:
```java
	WebRequest web = new WebRequest("http://google.com", listener);
    	RequestQueue queue = Volley.newRequestQueue(this);
	queue.add(web);
```

You can send values ​​using the following methods:
```java
	ReqMethod.GET   //GET
	ReqMethod.POST  //POST
	ReqMethod.PUT   //PUT
```

To select a method, you need to add it to the constructor, the default is GET method:
```java
	WebRequest web = new WebRequest(ReqMethod.POST, "http://google.com", listener);
```

To add value in request need:
```java
	web.AddField("key", "value")
	
	//Or add list
	ArrayList<String> list = new ArrayList<String>;
	list.add("value1");
	list.add("value2");
	web.AddList("key", list);
	
	//Or for array
	String[] values = {"value1", "value2"};
	web.AddList("key", values);
```

The values ​​of the list will be added in the following form: `key=value1&key=value2`


For example:
```java
	TextView notification = (TextView)findViewById(R.id.notification);
	RespListener listener = new RespListener() {
		@Override
		public void onResponse(String response) {
			notification.setText(response);
		}
	};
	WebRequest web = new WebRequest("http://google.com", listener);
	RequestQueue queue = Volley.newRequestQueue(context);
	//Add value
	web.AddField("key1", "value1");

	//Add array
	ArrayList<String> values = new ArrayList<>();
	values.add("value2");
	values.add("value3");
	web.AddList("key2", values);

	//start request
	queue.add(web);
```
	
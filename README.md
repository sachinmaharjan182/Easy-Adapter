# Easy-Adapter
Its the simple library for implementing recyclerview adapter easily. 

Step 1. Add the JitPack repository to your build file

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  
Step 2. Add the dependency

dependencies {

	        implementation 'com.github.sachinmaharjan182:Easy-Adapter:1.0'
          
	}


# GUIDES

<li> Make sure you have data binding is enabled in your gradle.
<li> Pass "null" as second paramter if you dont want callback.
	
	class PostAdapter(context:Context,callback:Any?)
    : BaseAdapter<Post, Any>(context,callback) {

    override fun setLayout(): Int {
        return R.layout.row_post
    }
	}


<li>  Extend your class with BaseAdapter




    //Category is the type of the object you want in adapter and categorylistener is the callback
    class CategoryAdapter(context: Context,callback:CategoryListener?)
    : BaseAdapter<Category,CategoryListener>(context,callback) {

    override fun setLayout(): Int {
        //Return the layout 
        return R.layout.row_home_category
    }
}



 
 
 viewModel.categorylist.observe(this, Observer{
            it->
            if (it != null) {
                adapter.updateList(it)
            }
        })





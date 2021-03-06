package br.com.luanadev.activityresult

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.AbsListView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class StateListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val listView = ListView(this)
        setContentView(listView)
        val stateList = resources.getStringArray(R.array.states)
        val listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, stateList)
        listView.adapter = listAdapter
        listView.choiceMode = AbsListView.CHOICE_MODE_SINGLE
        val state = intent.getStringExtra(EXTRA_STATE)
        if (state != null){
            val position = stateList.indexOf(state)
            listView.setItemChecked(position, true)
        }
        listView.setOnItemClickListener { parent, _, position, _ ->
            val result = parent.getItemAtPosition(position) as String
            val intent = Intent()
            intent.putExtra(EXTRA_RESULT, result)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

    companion object{
        const val EXTRA_STATE = "estado"
        const val EXTRA_RESULT = "result"
    }
}
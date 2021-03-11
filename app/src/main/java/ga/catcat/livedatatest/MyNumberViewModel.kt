package ga.catcat.livedatatest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

enum class ActionType {
    SET
}
class MyNumberViewModel : ViewModel() {
    companion object {
        private const val TAG = "MyNumberViewModel"
    }

    private val _currentValue = MutableLiveData<Int>()

    val currentValue : LiveData<Int>
        get() = _currentValue

    init {
        _currentValue.value = 0
    }

    fun updateValue(actionType: ActionType,input:Int){
        when(actionType){
            ActionType.SET ->
                _currentValue.value = input
        }
    }


}
# Dialogs
**Contents**

*   [Create Custom List](#create-custom-list)
*   [Dialog Confirmation](#dialog-confirmation)
*   [Dialog Text Only](#dialog_text_only)
*   [Input Text Affix](#input-text-affix)
*   [Input Text Icon](#input-text-icon)
*   [Input Text Area](#input-text-area)
*   [Input Text Dropdown](#input-text-dropdown)

## Create Custom List

```kt
import com.dimasbintang.design_system.helper.DropdownMapper.addItemDropdown
import com.dimasbintang.design_system.helper.BoxiconMapper.getDrawableBoxicon
import com.dimasbintang.design_system.model.ItemDropdown

val items = arrayListOf<ItemDropdown>()
items.addItemDropdown("Alarm") // item only contains text
items.addItemDropdown("Alarm", getDrawableBoxicon(this, "bx_alarm")) // item with start icon
items.addItemDropdown("Alarm", null, getDrawableBoxicon(this, "bx_alarm")) // item with end icon
items.addItemDropdown("Alarm", getDrawableBoxicon(this, "bx_alarm"), getDrawableBoxicon(this, "bx_plus")) // item with both start and end icon
// getDrawableBoxicon(this, "icon_name")) function for get drawable by name
```

## Dialog Confirmation
<img width="270" height="550" alt="Input Text Plain with Title" src="dialog_confirmation.gif" /> 

In the code:
```kt
val dialog = DialogConfirmation("Title", "Message dialog confirmation", "Confirm", "Cancel")
dialog.positiveListener = {
    // action positive button got click
    dialog.dismiss()
}
dialog.negativeListener = {
    // action positive button got click
    dialog.dismiss()
}
dialog.show(supportFragmentManager, null)
```

## Dialog List 
Text Only | Left Icon | Right Icon | Both Icon
------ | ------ | ------ | ------
<img width="270" height="550" alt="Text Only" src="dialog_text_only.gif" /> | <img width="270" height="550" alt="Left Icon" src="dialog_left_icon.gif" /> | <img width="270" height="550" alt="Right Icon" src="dialog_right_icon.gif" /> | <img width="270" height="550" alt="Both Icon" src="dialog_both_icon.gif" />

In the code:
```kt
val dialog = ListDialog(this, items, false)
dialog.confirmListener = {
    // action positive button got click
}
dialog.show(supportFragmentManager, null)
```

## Dialog List Multiple Select
<img width="270" height="550" alt="Multiple Select" src="dialog_multiple.gif" /> 

In the code:
```kt
val dialog = ListDialog(this, items, true)
dialog.confirmListener = {
    // action positive button got click
}
dialog.show(supportFragmentManager, null)
```

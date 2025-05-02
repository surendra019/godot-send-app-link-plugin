Paste the addon in the ```addons``` folder

<pre>
func _on_share_button_pressed() -> void:
	if Engine.has_singleton("SendContentPlugin"):
		var s = Engine.get_singleton("SendContentPlugin")
		s.sendAppLink("Download app!") </pre>

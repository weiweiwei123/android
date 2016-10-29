package com.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class ABroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "A is Invoked!", Toast.LENGTH_SHORT).show();
		Bundle bundle=new Bundle();
		bundle.putString("A", "the message of A");
		setResultExtras(bundle);

	}

}

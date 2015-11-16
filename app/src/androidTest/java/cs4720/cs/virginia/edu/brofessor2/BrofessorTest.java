package cs4720.cs.virginia.edu.brofessor2;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.test.suitebuilder.annotation.MediumTest;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by sherriff on 11/15/15.
 */
public class BrofessorTest extends ActivityInstrumentationTestCase2 {
    private BrofessorActivity brofessorActivity;
    private Button getNameButton;
    private EditText nameEditText;
    private Instrumentation instrumentation;

    public BrofessorTest() {
        super(BrofessorActivity.class);
    }



    protected void setUp() throws Exception {
        super.setUp();

        setActivityInitialTouchMode(true);
        instrumentation = getInstrumentation();

        brofessorActivity = (BrofessorActivity)getActivity();
        getNameButton = (Button)brofessorActivity.findViewById(R.id.button);
        nameEditText = (EditText)brofessorActivity.findViewById(R.id.editText);

    }

    @MediumTest
    public void testLayout() {
        final View decorView = brofessorActivity.getWindow().getDecorView();
        ViewAsserts.assertOnScreen(decorView, getNameButton);
        ViewAsserts.assertOnScreen(decorView, nameEditText);
        assertTrue(View.VISIBLE == getNameButton.getVisibility());
        assertTrue(View.VISIBLE == nameEditText.getVisibility());
    }

    @MediumTest
    public void testName() {

        assertTrue(nameEditText.getText().toString().equals(""));
        TouchUtils.clickView(this, getNameButton);
        assertTrue(!nameEditText.getText().toString().equals(""));

    }
}

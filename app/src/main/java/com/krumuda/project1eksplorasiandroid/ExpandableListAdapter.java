package com.krumuda.project1eksplorasiandroid;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

class HeaderClass {
    public String headerText;
    public String subHeader;

    HeaderClass(String header, String subHeader) {
        this.headerText = header;
        this.subHeader = subHeader;
    }

    public String getHeaderText() {
        return headerText;
    }

    public String getSubHeader() {
        return subHeader;
    }
}

public class ExpandableListAdapter extends BaseExpandableListAdapter{

    private Context _context;
    private List<String> header; // header titles
    private List<String> subHeader; // subheader titles
    private List<Integer> listType;
    // Child data in format of header title, child title
    private HashMap<String, List<String>> child;

    public ExpandableListAdapter(Context context, List<String> listDataHeader, List<String> listDataSubHeader, List<Integer> listDataType, HashMap<String, List<String>> listChildData) {
        this._context = context;
        this.header = listDataHeader;
        this.subHeader = listDataSubHeader;
        this.listType = listDataType;
        this.child = listChildData;
    }

    @Override
    public int getGroupCount() {
        // Get header size
        return this.header.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        // return children count
        return this.child.get(this.header.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        // Get header position
        return new HeaderClass(this.header.get(groupPosition), this.subHeader.get(groupPosition));
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        // This will return the child
        return this.child.get(this.header.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean areAllItemsEnabled() {
//        return super.areAllItemsEnabled();
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        // Getting header title
        HeaderClass headerObj = (HeaderClass) getGroup(groupPosition);

        // Inflating header layout and setting text
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.group_heading, parent, false);
        }

        TextView header_text = (TextView) convertView.findViewById(R.id.heading_text);
        TextView subheader_text = (TextView) convertView.findViewById(R.id.subheading_text);
        ImageView arrow_indicator = (ImageView) convertView.findViewById(R.id.arrow_indicator);
        header_text.setText(headerObj.getHeaderText());
        subheader_text.setText(headerObj.getSubHeader());

        // If group is expanded then change the text into bold and change the
        // icon
        if (isExpanded) {
//            header_text.setTypeface(null, Typeface.BOLD);
            arrow_indicator.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
        } else {
            // If group is not expanded then change the text back into normal
            // and change the icon

//            header_text.setTypeface(null, Typeface.NORMAL);
            arrow_indicator.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
        }

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        // Getting child text
        final String childText = (String) getChild(groupPosition, childPosition);
        // Inflating child layout and setting textview
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.child_row, parent, false);
        }

        TextView child_text = (TextView) convertView.findViewById(R.id.child_text);

        child_text.setText(childText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
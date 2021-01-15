package model.nextPage;

import beans.nextPage.NextPageConfiguration;
import beans.nextPage.NextPageObject;

import java.util.ArrayList;
import java.util.List;

public class NextPageModel {

    //  Singleton
    private static NextPageModel nextPageModel;

    //  Lấy thể hiện của lớp
    public static NextPageModel getInstance() {

        //  Kiểm tra xem thử thể hiện null chưa
        if (nextPageModel == null) {

            //  Null thì tạo mới
            nextPageModel = new NextPageModel();

        }

        //  Trả vè thể hiện
        return nextPageModel;

    }

    //  Phương thức nhận vào trang hiện tại và trang tối đa để trả về 1 list page object, cái này áp dụng cho admin 7 object
    public List<NextPageObject> getListNextPageObjectAdmin(int nowPage, int maximunPage) {

        //  Khai báo list next page Object
        List<NextPageObject> resultList = new ArrayList<NextPageObject>();

        //  Kiểm tra xem thử max -1<7?
        if (maximunPage - 1 < 7) {

            //  Thì sẽ không có ...
            for (int i = 1; i <= maximunPage; i++) {
                if (i == nowPage) {
                    resultList.add(new NextPageObject(i + "", NextPageConfiguration.ACTIVE_LI));
                } else {
                    resultList.add(new NextPageObject(i + "", NextPageConfiguration.NORMAL));
                }
            }

            return resultList;

        }

        //  Đầu
        //  Kiểm tra xem nowPage có lớn hơn 1+3
        if (nowPage > 1 + 3) {

            //  Nếu như lớn hơn thì sẽ là 1.... số nhỏ hơn nowPage - nowPage
            resultList.add(new NextPageObject("1", NextPageConfiguration.NORMAL));
            resultList.add(new NextPageObject("...", NextPageConfiguration.NONE));
            resultList.add(new NextPageObject(nowPage - 1 + "", NextPageConfiguration.NORMAL));
            resultList.add(new NextPageObject(nowPage + "", NextPageConfiguration.ACTIVE_LI));

        } else {

            //  Nếu như không lớn hơn 1+3 thì sẽ có dạng 1->nowpage
            for (int i = 1; i <= nowPage; i++) {
                if(i!=nowPage){
                    resultList.add(new NextPageObject(i + "", NextPageConfiguration.NORMAL));
               }else{
                    resultList.add(new NextPageObject(i + "", NextPageConfiguration.ACTIVE_LI));
                }
            }

        }

        //  Đuôi
        //  Kiểm tra xem thứ có bé hơn maximunPage-3
        if (nowPage < maximunPage - 3) {

            //  Nếu bé hơn thì sẽ có dạng nowpage-nowpage+1-...-maximunpage
            resultList.add(new NextPageObject(nowPage + 1 + "", NextPageConfiguration.NORMAL));
            resultList.add(new NextPageObject("...", NextPageConfiguration.NONE));
            resultList.add(new NextPageObject(maximunPage + "", NextPageConfiguration.NORMAL));

        } else {

            //  Không bé hơn thì từ nowpage đi tới hết
            for (int i = nowPage + 1; i <= maximunPage; i++) {
                resultList.add(new NextPageObject(i + "", NextPageConfiguration.NORMAL));
            }

        }

        //  Kiểm tra xem thứ listResult có size là 7 chưa, chưa thì bổ sung cho tới khi nào đủ 7 thì thôi
        while (resultList.size() < 7) {

            //  Lấy ra vị trí của nowPage
            int index = 0;
            for (int i = 0; i < resultList.size(); i++) {
                if (resultList.get(i).getValue().equals(nowPage + "")) {
                    index = i;
                    break;
                }
            }

            //  Trước tiên duyệt qua trái xem thử có thể thêm vào không
            if (index - 1 > 0) {
                for (int i = index; i >= 0; i--) {

                    //  Kiểm phần từ là ...
                    if (resultList.get(i).getValue().equals("...")) {

                        //  Ta chèn thêm một số nhỏ hơn số trước đó ở trc ...
                        resultList.add(i + 1, new NextPageObject(Integer.parseInt(resultList.get(i + 1).getValue()) - 1 + "", NextPageConfiguration.NORMAL));
                        break;

                    }

                }
            }

            //  Kiểm tra nếu đủ 7 rồi thì break
            if (resultList.size() == 7) break;

            //  Néu không đủ 7 thì duyệt qua phải
            if (index + 1 < maximunPage) {
                for (int i = index; i < resultList.size(); i++) {

                    //  Kiểm phần từ là ...
                    if (resultList.get(i).getValue().equals("...")) {

                        //  Ta chèn thêm một số nhỏ hơn số trước đó ở sau ...
                        resultList.add(i, new NextPageObject(Integer.parseInt(resultList.get(i - 1).getValue()) + 1 + "", NextPageConfiguration.NORMAL));
                        break;

                    }

                }
            }

        }

        //  Trả về kết quả
        return resultList;

    }

}

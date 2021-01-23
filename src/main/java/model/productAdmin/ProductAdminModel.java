package model.productAdmin;

import beans.BeansConfiguration;
import beans.productAdmin.ProductAdmin;
import beans.productAdmin.ProductAdminColor;
import model.category.CategoryModel;
import model.color.ColorModel;
import model.importPrice.ImportPriceModel;
import model.manufacturer.ManufacturerModel;
import model.product.ProductModel;
import model.productDetailInformation.ProductDetailInformationModel;
import model.productImage.ProductImageModel;
import model.productInformation.ProductInformationModel;
import model.productIntroduction.ProductIntroductionModel;
import model.productPrice.ProductPriceModel;
import model.productStructure.ProductStructureModel;
import model.promotionalPrice.PromotionalPriceModel;
import model.size.SizeModel;

import java.util.ArrayList;
import java.util.List;

public class ProductAdminModel {

    private static ProductAdminModel productAdminModel;

    public static ProductAdminModel getInstance() {

        if (productAdminModel == null) {
            productAdminModel = new ProductAdminModel();
        }

        return productAdminModel;
    }

    public void update() {
        ProductModel.getInstance().update();
    }

    public List<ProductAdmin> getListProductByAll(String selectSearchAndSort,String sort,String search,int nowPage){

        List<ProductAdmin> products = new ArrayList<ProductAdmin>();

        //  Lấy danh sách tại bảng thong_tin_chi_tiet_sp
        ProductDetailInformationModel.getInstance().fillProductAdminFromALl(products, selectSearchAndSort,sort,search,BeansConfiguration.LINE_OF_ON_PAGE_QUAN_LY_SAN_PHAM,nowPage);

        //  Điền giá km
        PromotionalPriceModel.getInstance().fillPriceListProductAdmin(products);

        //  Điền giá nhập
        ImportPriceModel.getInstance().fillPriceListProductAdmin(products);

        //  Điền cấu tạo cho sản phẩm
        ProductStructureModel.getInstance().fillStructureProdcut(products);

        //  Điền thông tin cho sản phẩm
        ProductInformationModel.getInstance().fillInformationProduct(products);

        //  Điền giới thiệu cho sản phẩm
        ProductIntroductionModel.getInstance().fillProductIntroduction(products);

        //  Fill link hình ảnh cho các màu
        ProductImageModel.getInstance().fileLinkHinhAnhListProduct(products);

        return products;

    }

    public int getNumberOfMaxProductFromAll( String selectSearchAndSort, String search){
        return ProductDetailInformationModel.getInstance().getNumberOfMaxProductFromAll(selectSearchAndSort,search);
    }


    public List<ProductAdmin> getListProductFirst() {

        List<ProductAdmin> products = new ArrayList<ProductAdmin>();

        //  Lấy danh sách tại bảng thong_tin_chi_tiet_sp
        ProductDetailInformationModel.getInstance().fillProductAdminFirst(products, BeansConfiguration.LINE_OF_ON_PAGE_QUAN_LY_SAN_PHAM);

        //  Fill dữ liệu từ bảng sản phẩm vào nó
        ProductModel.getInstance().fillDataProduct(products);

        //  Fill tên danh mục
        CategoryModel.getInstance().fillNameForProductAdmin(products);

        //  Fill teen hang san xuat
        ManufacturerModel.getInstance().fillNameManufactureProductAdmin(products);

        //  Điền giá sp
        ProductPriceModel.getInstance().fillPriceListProductAdmin(products);

        //  Điền giá km
        PromotionalPriceModel.getInstance().fillPriceListProductAdmin(products);

        //  Điền giá nhập
        ImportPriceModel.getInstance().fillPriceListProductAdmin(products);

        //  Điền cấu tạo cho sản phẩm
        ProductStructureModel.getInstance().fillStructureProdcut(products);

        //  Điền thông tin cho sản phẩm
        ProductInformationModel.getInstance().fillInformationProduct(products);

        //  Điền giới thiệu cho sản phẩm
        ProductIntroductionModel.getInstance().fillProductIntroduction(products);

        //  Fill color
        ColorModel.getInstance().fillNameAndImgColorListProductAdmin(products);

        //  Fill size
        SizeModel.getInstance().fillNameSize(products);

        //  Fill link hình ảnh cho các màu
        ProductImageModel.getInstance().fileLinkHinhAnhListProduct(products);

        return products;
    }

    public int getNumberOfMaxProductFirst() {
        return ProductDetailInformationModel.getInstance().getNumberOfMaxProductFirst();
    }

    //  Phương thức nhận vô số mgg tối đa, trả về số trang tối đa
    public int getMaximunNumberOfPage(int maximumNumberOfPage) {
        return maximumNumberOfPage % BeansConfiguration.LINE_OF_ON_PAGE_QUAN_LY_SAN_PHAM > 0 ? maximumNumberOfPage / BeansConfiguration.LINE_OF_ON_PAGE_QUAN_LY_SAN_PHAM + 1 : maximumNumberOfPage / BeansConfiguration.LINE_OF_ON_PAGE_QUAN_LY_SAN_PHAM;
    }

    public int getNumberOfShow(List<ProductAdmin> products){
        int result = 0;
        for(ProductAdmin productAdmin : products){
            for(ProductAdminColor productAdminColor : productAdmin.getDanh_sach_mau()){
                result+=productAdminColor.getDanh_sach_size().size();
            }
        }
        return result;
    }



}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.ProductDAO;
import entity.Product;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.catalina.core.ApplicationContext;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author cyclingbd007
 */
public class ProductController extends ActionSupport {

    private Product product = new Product();
    private ProductDAO dao = new ProductDAO();
    private List<Product> productList;
    private String sm = "";
    private String em = "";

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductDAO getDao() {
        return dao;
    }

    public void setDao(ProductDAO dao) {
        this.dao = dao;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getSm() {
        return sm;
    }

    public void setSm(String sm) {
        this.sm = sm;
    }

    public String getEm() {
        return em;
    }

    public void setEm(String em) {
        this.em = em;
    }

    @Override
    public String execute() throws Exception {
        this.productList = dao.getAllProduct();
        return SUCCESS;
    }

    public String insertProduct() {
        product.setPname(product.getPname());
        product.setPrice(product.getPrice());
        product.setQty(product.getQty());
        boolean status = dao.saveProduct(product);
        if (status) {
            setSm("Product Saved successfully");
            return SUCCESS;
        } else {
            setEm("Product not saved successfully");
            return "input";
        }

    }

    public String updateProduct() {
        product.setPid(product.getPid());
        product.setPname(product.getPname());
        product.setPrice(product.getPrice());
        product.setQty(product.getQty());
        boolean status = dao.updateProduct(product);
        if (status) {
            setSm("Product Update successfully");
            return SUCCESS;
        } else {
            setEm("Product not Update");
            return "input";
        }

    }

    public String editProduct() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        int pid = Integer.parseInt(request.getParameter("pid"));

        if (dao.getProduct(pid) != null) {
            Product p = dao.getProduct(pid);
            product.setPid(p.getPid());
            product.setPname(p.getPname());
            product.setPrice(p.getPrice());
            product.setQty(p.getQty());
            return SUCCESS;
        }

        return "input";

    }

    public String deleteProduct() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        int pid = Integer.parseInt(request.getParameter("pid"));

        boolean status = dao.deleteProduct(pid);

        if (status) {
            setSm("Product deleted successfully");
            this.productList = dao.getAllProduct();
            return SUCCESS;
        } else {
            setEm("Product not delete");
            return "input";
        }
    }

}

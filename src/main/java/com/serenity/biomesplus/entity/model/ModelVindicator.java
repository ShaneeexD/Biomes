package com.serenity.biomesplus.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelIllager - Either Mojang or a mod author
 * Created using Tabula 7.0.1
 */
public class ModelVindicator extends ModelBase {
    public ModelRenderer field_191217_a;
    public ModelRenderer field_191223_g;
    public ModelRenderer field_191220_d;
    public ModelRenderer field_191221_e;
    public ModelRenderer field_191224_h;
    public ModelRenderer field_191218_b0;
    public ModelRenderer field_191218_b1;
    public ModelRenderer field_191219_c0;
    public ModelRenderer field_191219_c1;
    public ModelRenderer field_191217_aChild;
    public ModelRenderer field_191217_aChild_1;
    public ModelRenderer field_191219_cChild;

    public ModelVindicator() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.field_191221_e = new ModelRenderer(this, 0, 22);
        this.field_191221_e.mirror = true;
        this.field_191221_e.setRotationPoint(2.0F, 12.0F, 0.0F);
        this.field_191221_e.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.field_191220_d = new ModelRenderer(this, 0, 22);
        this.field_191220_d.setRotationPoint(-2.0F, 12.0F, 0.0F);
        this.field_191220_d.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.field_191223_g = new ModelRenderer(this, 40, 46);
        this.field_191223_g.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.field_191223_g.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.field_191217_aChild_1 = new ModelRenderer(this, 24, 0);
        this.field_191217_aChild_1.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.field_191217_aChild_1.addBox(-1.0F, -1.0F, -6.0F, 2, 4, 2, 0.0F);
        this.field_191217_a = new ModelRenderer(this, 0, 0);
        this.field_191217_a.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.field_191217_a.addBox(-4.0F, -10.0F, -4.0F, 8, 10, 8, 0.0F);
        this.field_191219_cChild = new ModelRenderer(this, 44, 22);
        this.field_191219_cChild.mirror = true;
        this.field_191219_cChild.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.field_191219_cChild.addBox(4.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F);
        this.field_191218_b0 = new ModelRenderer(this, 16, 20);
        this.field_191218_b0.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.field_191218_b0.addBox(-4.0F, 0.0F, -3.0F, 8, 12, 6, 0.0F);
        this.field_191224_h = new ModelRenderer(this, 40, 46);
        this.field_191224_h.mirror = true;
        this.field_191224_h.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.field_191224_h.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.field_191217_aChild = new ModelRenderer(this, 32, 0);
        this.field_191217_aChild.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.field_191217_aChild.addBox(-4.0F, -10.0F, -4.0F, 8, 12, 8, 0.0F);
        this.field_191218_b1 = new ModelRenderer(this, 0, 38);
        this.field_191218_b1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.field_191218_b1.addBox(-4.0F, 0.0F, -3.0F, 8, 18, 6, 0.5F);
        this.field_191219_c0 = new ModelRenderer(this, 44, 22);
        this.field_191219_c0.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.field_191219_c0.addBox(-8.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F);
        this.setRotateAngle(field_191219_c0, -0.75F, 0.0F, 0.0F);
        this.field_191219_c1 = new ModelRenderer(this, 40, 38);
        this.field_191219_c1.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.field_191219_c1.addBox(-4.0F, 2.0F, -2.0F, 8, 4, 4, 0.0F);
        this.setRotateAngle(field_191219_c1, -0.75F, 0.0F, 0.0F);
        this.field_191217_a.addChild(this.field_191217_aChild_1);
        this.field_191219_c0.addChild(this.field_191219_cChild);
        this.field_191217_a.addChild(this.field_191217_aChild);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.field_191221_e.render(f5);
        this.field_191220_d.render(f5);
        this.field_191223_g.render(f5);
        this.field_191217_a.render(f5);
        this.field_191218_b0.render(f5);
        this.field_191224_h.render(f5);
        this.field_191218_b1.render(f5);
        this.field_191219_c0.render(f5);
        this.field_191219_c1.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

public class CurrentItemMod extends DraggableMod{
private ScreenPosition pos = ScreenPosition.fromRelativePostion(0.5, 0.5);
	
	@Override
	public int getWitdht() {
		return 60;
	}

	@Override
	public int getHeight() {
		return 15;
	}

	@Override
	public void render(ScreenPosition pos) {
		ItemStack item = mc.thePlayer.getHeldItem();
		renderItemStack(pos, 2, item);
		
	}
	@Override 
	public void renderDummy(ScreenPosition pos) {
		renderItemStack(pos, 2, new ItemStack(Items.diamond_sword));
	}

	private void renderItemStack(ScreenPosition pos, int i, ItemStack is) {
		
		if(is == null	) {
			return;
		}
		GL11.glPushMatrix();
		int yAdd = (-16 * 3) + 48;
		if(mc.thePlayer !=null && is !=null) {
		   if(is.getItem().isDamageable()) {
			  double damage = (is.getMaxDamage() - is.getItemDamage()) / (double) is.getMaxDamage() * 100;
			  font.drawString(String.format("%.2f%%", damage), pos.getAbsoluteX() + 20, pos.getAbsoluteY() + yAdd + 5, -1);
		  }
		
		  if(is.isStackable() && mc.thePlayer.getHeldItem().stackSize !=1) {
			  font.drawString(Integer.toString(mc.thePlayer.getHeldItem().stackSize), pos.getAbsoluteX() + 20, pos.getAbsoluteY() + yAdd + 5, -1);
			
		  }
		 
		  RenderHelper.enableGUIStandardItemLighting();
		  mc.getRenderItem().func_175042_a(is, pos.getAbsoluteX(), pos.getAbsoluteY() + yAdd);
		  GL11.glPopMatrix();
		}
	}

	@Override
	public void save(ScreenPosition pos) {
		this.pos = pos;
		
	}

	@Override
	public ScreenPosition load() {
		return pos;
	}

}

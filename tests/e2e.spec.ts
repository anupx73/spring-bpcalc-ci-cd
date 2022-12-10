import { test, expect } from '@playwright/test';

test.beforeEach(async ({ page }) => {
  await page.goto("https://spring-bpcalc-lxwpse7yja-ez.a.run.app");
});

test('Check home page title', async ({ page }) => {
  // Expect a title BP Calculator
  await expect(page).toHaveTitle(/BP/);
});

test('Verify ideal blood pressure category', async ({ page }) => {
  // Input systolic: 110, diastolic: 70
  await page.locator("#systolic.form-control").fill("110");
  await page.locator("#diastolic.form-control").type("70");
  
  // Press Calculate button
  await page.getByRole('button', { name: 'Calculate' }).click();

  // Verify the calculated pressure category
  const result = page.locator(".input-group.alert.alert-primary");
  await expect(result).toHaveText("Ideal Blood Pressure");
});

test('Verify high blood pressure category', async ({ page }) => {
  // Input systolic: 120, diastolic: 90
  await page.locator("#systolic.form-control").fill("120");
  await page.locator("#diastolic.form-control").type("90");
  
  // Press Calculate button
  await page.getByRole('button', { name: 'Calculate' }).click();

  // Verify the calculated pressure category
  const result = page.locator(".input-group.alert.alert-primary");
  await expect(result).toHaveText("High Blood Pressure");
});

test('Verify history page', async ({ page }) => {
  // Press History button
  await page.locator(".btn.btn-outline-primary").click();

  // Verify the calculated pressure category
  const result = page.locator(".input-group.alert.alert-info");
  await expect(result).toContainText("Pre-High Blood Pressure");
});
